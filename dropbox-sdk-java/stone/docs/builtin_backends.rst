****************
Builtin Backends
****************

Using a backend, you can convert the data types and routes in your spec into
objects in your programming language of choice.

Stone includes backends for an assortment of languages, including:

* `Python <#python-guide>`_
* Python `Type Stubs <https://www.python.org/dev/peps/pep-0484/#id42>`_
* Javascript
* Objective-C
* Swift
* Typescript

If you're looking to write your own backend, see `Backend Reference
<backend_ref.rst>`_. We would love to see a contribution of a PHP or Ruby
backend.

Compile with the CLI
====================

Compiling a spec and generating code is done using the ``stone``
command-line interface (CLI)::

    $ stone -h
    usage: stone [-h] [-v] [--clean-build] [-f FILTER_BY_ROUTE_ATTR]
                 [-w WHITELIST_NAMESPACE_ROUTES | -b BLACKLIST_NAMESPACE_ROUTES]
                 backend output [spec [spec ...]]

    StoneAPI

    positional arguments:
      backend               Either the name of a built-in backend or the path to
                            a backend module. Paths to backend modules must
                            end with a .stoneg.py extension. The following
                            backends are built-in: js_client, js_types,
                            tsd_client, tsd_types, python_types, python_client,
                            swift_client
      output                The folder to save generated files to.
      spec                  Path to API specifications. Each must have a .stone
                            extension. If omitted or set to "-", the spec is read
                            from stdin. Multiple namespaces can be provided over
                            stdin by concatenating multiple specs together.

    optional arguments:
      -h, --help            show this help message and exit
      -v, --verbose         Print debugging statements.
      --clean-build         The path to the template SDK for the target language.
      -f FILTER_BY_ROUTE_ATTR, --filter-by-route-attr FILTER_BY_ROUTE_ATTR
                            Removes routes that do not match the expression. The
                            expression must specify a route attribute on the left-
                            hand side and a value on the right-hand side. Use
                            quotes for strings and bytes. The only supported
                            operators are "=" and "!=". For example, if "hide" is
                            a route attribute, we can use this filter:
                            "hide!=true". You can combine multiple expressions
                            with "and"/"or" and use parentheses to enforce
                            precedence.
      -w WHITELIST_NAMESPACE_ROUTES, --whitelist-namespace-routes WHITELIST_NAMESPACE_ROUTES
                            If set, backends will only see the specified
                            namespaces as having routes.
      -b BLACKLIST_NAMESPACE_ROUTES, --blacklist-namespace-routes BLACKLIST_NAMESPACE_ROUTES
                            If set, backends will not see any routes for the
                            specified namespaces.

We'll generate code based on an ``calc.stone`` spec with the following
contents::

    namespace calc

    route eval(Expression, Result, EvalError)

    struct Expression
        "This expression is limited to a binary operation."
        op Operator = add
        left Int64
        right Int64

    union Operator
        add
        sub
        mult
        div Boolean
            "If value is true, rounds up. Otherwise, rounds down."

    struct Result
        answer Int64

    union EvalError
        overflow

Python Guide
============

This section explains how to use the pre-packaged Python backends and work
with the Python classes that have been generated from a spec.

There are two different Python backends: ``python_types`` and
``python_client``. The former generates Python classes for the data types
defined in your spec. The latter generates a single Python class with a method
per route, which is useful for building SDKs.

We'll use the ``python_types`` backend::

    $ stone python_types . calc.stone

This runs the backend on the ``calc.stone`` spec. Its output target is
``.`` which is the current directory. A Python module is created for
each declared namespace, so in this case only ``calc.py`` is created.

Three additional modules are copied into the target directory. The first,
``stone_validators.py``, contains classes for validating Python values against
their expected Stone types. You will not need to explicitly import this module,
but the auto-generated Python classes depend on it. The second,
``stone_serializers.py``, contains a pair of ``json_encode()`` and
``json_decode()`` functions. You will need to import this module to serialize
your objects. The last is ``stone_base.py`` which shouldn't be used directly.

In the following sections, we'll interact with the classes generated in
``calc.py``. For simplicity, we'll assume we've opened a Python interpreter
with the following shell command::

    $ python -i calc.py

For non-test projects, we recommend that you set the generation target to a
path within a Python package, and use Python's import facility.

Primitive Types
---------------

The following table shows the mapping between a Stone `primitive type
<lang_ref.rst#primitive-types>`_ and its corresponding type in Python.

========================== ============== =====================================
Primitive                  Python 2.x / 3    Notes
========================== ============== =====================================
Bytes                      bytes
Boolean                    bool
Float{32,64}               float          long type within range is converted.
Int{32,64}, UInt{32,64}    long
List                       list
String                     unicode / str  str type is converted to unicode.
Timestamp                  datetime
========================== ============== =====================================

Struct
------

For each struct in your spec, you will see a corresponding Python class of the
same name.

In our example, ``Expression``, ``Operator``, ``Answer``, ``EvalError``, and
are Python classes. They have an attribute (getter/setter/deleter property) for
each field defined in the spec. You can instantiate these classes and specify
field values either in the constructor or by assigning to an attribute::

    >>> expr = Expression(op=Operator.add, left=1, right=1)

If you assign a value that fails validation, an exception is raised::

    >>> expr.op = '+'
    Traceback (most recent call last)
    ...
    ValidationError: expected type Operator or subtype, got string

Accessing a required field (non-optional with no default) that has not been set
raises an error::

    >>> res = Result()
    >>> res.answer
    Traceback (most recent call last):
      File "<stdin>", line 1, in <module>
      File "calc.py", line 221, in answer
        raise AttributeError("missing required field 'answer'")
    AttributeError: missing required field 'answer'

Other characteristics:

    1. Inheritance in Stone is represented as inheritance in Python.
    2. If a field is nullable and was never set, ``None`` is returned.
    3. If a field has a default but was never set, the default is returned.

Union
-----

For each union in your spec, you will see a corresponding Python class of the
same name.

You do not use a union class's constructor directly. To select a tag with a
void type, use the class attribute of the same name::

    >>> EvalError.overflow
    EvalError('overflow', None)

To select a tag with a value, use the class method of the same name and pass
in an argument to serve as the value::

    >>> Operator.div(False)
    Operator('div', False)

To write code that handles the union options, use the ``is_[tag]()`` methods.
We recommend you exhaustively check all tags, or include an else clause to
ensure that all possibilities are accounted for. For tags that have values,
use the ``get_[tag]()`` method to access the value::

    >>> # assume that op is an instance of Operator
    >>> if op.is_add():
    ...     # handle addition
    ... elif op.is_sub():
    ...     # handle subtraction
    ... elif op.is_mult():
    ...     # handle multiplication
    ... elif op.is_div():
    ...     round_up = op.get_div()
    ...     # handle division

Struct Polymorphism
-------------------

As with regular structs, structs that enumerate subtypes have corresponding
Python classes that behave identically to regular structs.

The difference is apparent when a field has a data type that is a struct with
enumerated subtypes. Expanding on our example from the language reference,
assume the following spec::

    struct Resource
        union
            file File
            folder Folder

        path String

    struct File extends Resource:
        size UInt64

    struct Folder extends Resource:
        "No new fields."

    struct Response
        rsrc Resource

If we instantiate ``Response``, the ``rsrc`` field can only be assigned a
``File`` or ``Folder`` object. It should not be assigned a ``Resource`` object.

An exception to this is on deserialization. Because ``Resource`` is specified
as a catch-all, it's possible when deserializing a ``Response`` to get a
``Resource`` object in the ``rsrc`` field. This indicates that the returned
subtype was unknown because the recipient has an older spec than the sender.
To handle catch-alls, you should use an else clause::

    >>> print resp.rsrc.path  # Guaranteed to work regardless of subtype
    >>> if isinstance(resp, File):
    ...     # handle File
    ... elif isinstance(resp, Folder):
    ...     # handle Folder
    ... else:
    ...     # unknown subtype of Resource

Route
-----

Routes are represented as instances of a ``Route`` object. The generated Python
module for the namespace will have a module-level variable for each route::

    >>> eval
    Route('eval', 1, False, ...)

Route attributes specified in the spec are available as a dict in the ``attrs``
member variable. Route deprecation is stored in the ``deprecated`` member
variable. The name and version of a route are stored in the ``name`` and ``version`` member
variables, respectively.

Serialization
-------------

We can use ``stone_serializers.json_encode()`` to serialize our objects to
JSON::

    >>> import stone_serializers
    >>> stone_serializers.json_encode(eval.result_type, Result(answer=10))
    '{"answer": 10}'

To deserialize, we can use ``json_decode``::

    >>> stone_serializers.json_decode(eval.result_type, '{"answer": 10}')
    Result(answer=10)

There's also ``json_compat_obj_encode`` and ``json_compat_obj_decode`` for
converting to and from Python primitive types rather than JSON strings.

Route Functions
---------------

To generate functions that represent routes, use the ``python_client``
generator::

    $ stone python_client . calc.stone -- -m client -c Client -t myservice

``-m`` specifies the name of the Python module to generate, in this case
``client.py``. The important contents of the file look as follows::

    class Client(object):
        __metaclass__ = ABCMeta

        @abstractmethod
        def request(self, route, namespace, arg, arg_binary=None):
            pass

        # ------------------------------------------
        # Routes in calc namespace

        def calc_eval(self,
                      left,
                      right,
                      op=calc.Operator.add):
            """
            :type op: :class:`myservice.calc.Operator`
            :type left: long
            :type right: long
            :rtype: :class:`myservice.calc.Result`
            :raises: :class:`.exceptions.ApiError`

            If this raises, ApiError will contain:
                :class:`myservice.calc.EvalError`
            """
            arg = calc.Expression(left,
                                  right,
                                  op)
            r = self.request(
                calc.eval,
                'calc',
                arg,
                None,
            )
            return r

``-c`` specified the name of the abstract class to generate. Using this class,
you'll likely want to inherit the class and implement the request function. For
example, an API that goes over HTTP might have the following client::

    import requests  # use the popular HTTP library

    from .stone_serializers import json_decode, json_encode
    from .exceptions import ApiError  # You must implement this

    class MyServiceClient(Client):

        def request(self, route, namespace, arg, arg_binary=None):
            url = 'https://api.myservice.xyz/{}/{}'.format(
                    namespace, route.name)
            r = requests.get(
                url,
                headers={'Content-Type': 'application/json'},
                data=json_encode(route.arg_type, arg))
            if r.status_code != 200:
                raise ApiError(...)
            return json_decode(route.result_type, r.content)

Note that care is taken to ensure that that the return type and exception type
match those that were specified in the automatically generated documentation.

Routes with Version Numbers
---------------------------

There can be multiple versions of routes sharing the same name. For each route with a version
numbers other than 1, the generated module-level route variable and route function have a version
suffix appended in the form of ``{name}_v{version}``.

For example, suppose we add a new version of route ``eval`` in ``calc.stone`` as follows::

    ...

    route eval:2(Expression, ResultV2, EvalError)

    struct ResultV2
        answer String

    ...

The module-level variable for the route will be::

    >>> eval_v2
    Route('eval', 2, False, ...)

And the corresponding route function in ``client.py`` will be ``calc_eval_v2``.
