******************
Language Reference
******************

.. contents:: Table of Contents

Your API is described by specification files written in the Stone language.
Here we'll cover the various capabilities at your disposal for expressing the
intricacies of your API.

Choosing a Filename
===================

All specification files end with a ``.stone`` extension. We recommend that the
name of the file be the same as the `namespace`_ defined in the spec. If
multiple files are part of the same namespace, we recommend that they all share
the same prefix: the namespace name followed by an underscore.

Comments
========

Any text between a hash ``#`` and a newline is considered a comment. Comments
can occupy an entire line or be added after non-comments on a line.

Use comments to explain a section of the spec to a reader of the spec. Unlike
`documentation strings <#documentation>`_, comments are not accessible to
generators and will not appear in generated output.

Namespace
=========

Specs must begin with a namespace declaration as is the case here::

   namespace example

This logically groups all of the routes and data types in the spec file into
the ``example`` namespace. A spec file must declare exactly one namespace, but
multiple spec files may contribute to the same namespace.

Namespaces are useful for grouping related functionality together. For example,
the Dropbox API has a namespace devoted to all file operations (uploading,
downloading, ...), and another namespace for all operations relevant to user
accounts.

Basic Types
===========

In the example, ``String`` and ``Timestamp`` are basic types. Here's a
table of all such types and the arguments they take:

======================= ================================= =====================
Type                    Arguments (**bold** are required  Notes
                        and positional)
======================= ================================= =====================
Bytes                                                     An array of bytes.
Boolean
Float{32,64}            * min_value
                        * max_value
Int{32,64}, UInt{32,64} * min_value
                        * max_value
List                    * **data_type**: A primitive or   Lists are homogeneous.
                          composite type.
                        * min_items
                        * max_items
Map                     * **key_data_type**: Must be an   Maps must have keys
                          instance of the String base     that are a String
                          type.                           type.  Values can be
                        * **value_data_type**: A          any primitive or
                          primitive or composite type.    composite as long as
                                                          they are homogeneous.
String                  * min_length                      A unicode string.
                        * max_length
                        * pattern: A regular expression
                          to be used for validation.
Timestamp               * **format**: Specified as a      This is used by the
                          string understood by            JSON-serializer since
                          strptime().                     it has no native
                                                          timestamp data type.
Void
======================= ================================= =====================

Positional arguments (bold in the above table) are always required and appear
at the beginning of an argument list::

    List(Int64)

Keyword arguments are optional and are preceded by the argument name and an
``=``::

    Int64(max_value=130)

If both are needed, positional come before keyword arguments::

    List(Int64, max_items=5)

If no arguments are needed, the parentheses can be omitted::

    UInt64

We'll put these to use in the user-defined types section.

Mapping to Target Languages
---------------------------

Code generators map the primitive types of Stone to types in a target language.
For more information, consult the appropriate guide in `Builtin Backends
<builtin_backends.rst>`_.

Alias
=====

Aliases let you parameterize a type once with a name and optional documentation
string, and then use that name elsewhere::

    alias Age = UInt64(max_value=120)
        "The age of a human."

Aliases reduce repetition, improve readability of specs, and make refactoring
easier since there's a single source of truth.

Aliases can reference user-defined types and other aliases, and can make a type
nullable.

Struct
======

A struct is a user-defined composite type made up of fields::

    struct Person
        "Describes a member of society."

        name String
            "Given name followed by surname."
        age UInt64
            "The number of years, rounded down."

A struct can be documented by specifying a string immediately following the
struct declaration. The string can be multiple lines, as long as each
subsequent line is at least at the indentation of the starting quote.
Refer to `Documentation`_ for more.

Following the documentation is a list of fields. Fields are formatted with the
field name first followed by the field type. Documentation for a field is
specified on a new indented line.

Inheritance
-----------

Using the ``extends`` keyword, a struct can declare a parent type. The sub type
inherits all of the fields of the parent::

    struct ModernPerson extends Person
        email String(pattern="^[^@]+@[^@]+\.[^@]+$")?
            "Set if this person has an e-mail address."

``ModernPerson`` inherits ``name`` and ``age`` from ``Person``.

Unless explicitly mentioned, generators will translate this relationship into
their target language.

Composition
-----------

User-defined types can be composed of other user-defined types::

    struct Person
        "Describes a member of society."

        name Name
        age UInt64
            "The number of years, rounded down."
        food_pref FoodPreference

    struct Name
        "Separates a name into components."

        given_name
            "Also known as first name."
        surname
            "Also known as family name."

    union FoodPreference
        anything
        vegetarian
        vegan
        pescetarian
        carnivore

Nested Definitions
------------------

If you're composing a type that won't be used anywhere else, you can define the
type inline::

    struct Person
        "Describes a member of society."

        name Name
            struct
                "Separates a name into components."
                given_name
                    "Also known as first name."
                surname
                    "Also known as family name."
        age UInt64
            "The number of years, rounded down."
        food_pref FoodPreference
            union
                anything
                vegetarian
                vegan
                pescetarian
                carnivore

The inline definition is identical to a top-level definition, except that the
name is omitted as it's already specified as the type for the field.

Defaults
--------

A field with a primitive type can have a default set with a ``=`` followed by
a value at the end of the field declaration::

    struct Person
        name String = "John Doe"

Setting a default means that the field is optional. If it isn't specified, then
the field assumes the value of the default.

A default cannot be set for a nullable type. Nullable types implicitly have a
default of ``null``.

A default can be set for a field with a union data type, but only to a union
member with a void type::

    struct Person
        "Describes a member of society."

        name Name
        age UInt64
            "The number of years, rounded down."
        food_pref FoodPreference = anything

In practice, defaults are useful when `evolving a spec <evolve_spec.rst>`_.

Examples
--------

Examples let you include realistic samples of data in definitions. This gives
spec readers a concrete idea of what typical values will look like. Also,
examples help demonstrate how distinct fields might interact with each other.

Backends have access to examples, which is useful when automatically
generating documentation.

An example is declared by using the ``example`` keyword followed by a label.
By convention, "default" should be used as the label name for an example that
can be considered a good representation of the general case for the type::

    struct Person
        "Describes a member of society."

        name Name
        age UInt64
            "The number of years, rounded down."
        food_pref FoodPreference = anything

        example boy
            name = male_name
            age = 13

        example grandpa
            "A grandpa who has gone vegetarian."
            name = male_name
            age = 93
            food_pref = vegetarian

    struct Name
        "Separates a name into components."

        given_name
            "Also known as first name."
        surname
            "Also known as family name."

        example male_name
            given_name = "Greg"
            surname = "Kurtz"

Every required field (not nullable and no default) must be specified. ``null``
can be used to mark that a nullable type is not present.

An optional multi-line documentation string can be specified after the line
declaring the example and before the example fields.

Note that when you have a set of nested types, each type defines examples for
its fields with primitive types. For fields with user-defined types, the value
of the example must be a label of an example in the target type.

Lists can be expressed with brackets::

    struct ShoppingList
        items List(String)

        example default
            items = ["bananas", "yogurt", "cheerios"]

Maps are expressed with curly braces::

    struct Colors
        similar_colors Map(String, List(String))

        example default
            similar_colors = {"blue": ["aqua", "azure"], "red": ["crimson"], "green": []}

Map examples can also be multiline (Be mindful of indentation rules)::

    struct Digits
        digit_mapping Map(String, Map(String, Int32))

        example default
            digit_mapping = {
                "one": {
                    "one": 11,
                    "two": 12
                },
                "two": {
                    "one": 21,
                    "two": 22
                }
            }
Union
=====

Stone's unions are `tagged unions <http://en.wikipedia.org/wiki/Tagged_union>`_.
Think of them as a type that can store one of several different possibilities
at a time. Each possibility has an identifier that is called a "tag".

Each tag is associated with a type (``inactive`` stores a ``Timestamp``). If
the type is omitted as in the case of ``active``, the type is implicitly
``Void``.

In this example, the union ``Shape`` has tags ``point``, ``square``, and
``circle``::

    union Shape
        point
        square Float64
            "The value is the length of a side."
        circle Float64
            "The value is the radius."

The primary advantage of a union is its logical expressiveness. You'll often
encounter types that are best described as choosing between a set of options.
Avoid the common anti-pattern of using a struct with a nullable field for each
option, and relying on your application logic to enforce that only one is set.

Another advantage is that for languages that support tagged unions (Swift is
a recent adopter), the compiler can check that the application code handles all
possible cases and that accesses are safe. Backends will take advantage of
such features when they are available in the target language.

Like a struct, a documentation string can follow the union declaration and/or
follow each tag definition.

Closed Unions
-------------

By default, unions are open. That is, for the sake of backwards compatibility,
a recipient of a message should be prepared to handle a tag that wasn't defined
in the version of the API specification known to it. Stone exposes a virtual
tag called ``other`` of void type to generators that is known as the
"catch-all" tag for this purpose. If a recipient receives a tag that it isn't
aware of, it will default the union to the ``other`` tag.

If you don't need this flexibility, and can promise that no additional tags
will be added in the future, you can "close" the union. To do so, use the
``union_closed`` keyword::

    union_closed Resource
        file
        folder

With the above specification, a recipient can confidently handle the "file" and
"folder" tags and trust that no other value will ever be encountered.

Note: We defaulted unions to being open because it's preferable for a
specification writer to forget to close a union than forget to open one. The
latter case is backwards-incompatible change for clients.

.. _union-inheritance:

Inheritance
-----------

Using the ``extends`` keyword, a union can declare a parent type. The new union
inherits all of the options of the parent type.

However, this relationship is not expected to be translated by generators into
most target languages. The reason for this is that unlike struct inheritance,
union inheritance allows the parent type to substitute the child type rather
than the reverse. That's because the selected tag will always be known by the
child type, but a child's tag won't necessarily be known by the parent. In most
languages, this relationship cannot be natively modeled.

.. _union-examples:

Examples
--------

Examples for unions must only specify one field, since only one union member
can be selected at a time. For example::

    union Shape
        point
        square Float64
            "The value is the length of a side."
        circle Float64
            "The value is the radius."

        example default
            point = null

        example big_circle
            circle = 1024.0

In the ``default`` example, note that tags with void types are specified with
a value of ``null``. In the ``big circle`` example, the ``circle`` tag has an
associated float value.

Struct Polymorphism
===================

If a struct enumerates its subtypes, an instance of any subtype will satisfy
the type constraint. This is useful when wanting to discriminate amongst types
that are part of the same hierarchy while simultaneously being able to avoid
discriminating when accessing common fields.

To declare the enumeration, define a union following the documentation string
of the struct if one exists. Unlike a regular union, it is unnamed. Each member
of the union specifies a tag followed by the name of a subtype. The tag (known
as the "type tag") is present in the serialized format to distinguish between
subtypes. For example::

    struct Resource
        union
            file File
            folder Folder

        path String

    struct File extends Resource
        ...

    struct Folder extends Resource
        ...

Anywhere ``Resource`` is referenced, an instance of ``File`` or ``Folder``
satisfies the type constraint.

A struct that enumerates subtypes cannot inherit from any other struct. Also,
type tags cannot match any field names.

Open vs. Closed
---------------

Similar to a union, a struct with enumerated types defaults to open but can
be explicitly marked as closed::

    struct Resource
        "Sample doc."

        union_closed
            file File
            folder Folder

        path String

    struct File extends Resource:
        ...

    struct Folder extends Resource:
        ...

If recipient receives a tag for a subtype that it is unaware of, it will
substitute the base struct in its place. In the example above, if the subtype
is a ``Symlink`` (not shown), then the recipient will return a ``Resource`` in
its place.

Nullable Type
=============

When a type is followed by a ``?``, the type is nullable::

    String?

Nullable means that the type can be unspecified, ie. ``null``. Code generators
should use a language's native facilities for null,
`boxed types
<http://en.wikipedia.org/wiki/Object_type_(object-oriented_programming)#Boxing>`_,
and `option types <http://en.wikipedia.org/wiki/Option_type>`_ if possible. For
languages that do not support these features, a separate function to check for
the presence of a type is the preferred method.

A nullable type is considered optional. If it is not specified, it assumes the
value of null.

Route
=====

Routes correspond to your API endpoints. Each route is defined by a signature
of three data types formatted as ``(Arg, Result, Error)``. Here's an example::

    namespace calc

    route binary_op(BinaryOpArg, Result, BinaryOpError)
        "Performs the requested binary operation calculation."

    struct BinaryOpArg
        op Operator
        left Int64
        right Int64

    union Operator
        add
        sub

    struct Result
        answer Int64

    union BinaryOpError
        overflow

The route is named ``binary_op``. ``BinaryOpsArg`` is the argument to the route.
``Result`` is returned on success. ``BinaryOpError`` is returned on failure.

As is the case with structs and unions, a documentation string may follow the
route signature.

Attributes
----------

A full description of an API route tends to require vocabulary that is specific
to a service. For example, the Dropbox API needs a way to specify different
hostnames that routes map to, and a way to indicate which routes need
authentication.

To cover this open-ended use case, routes can have a set of custom attributes
(``key = value`` pairs) like follows::

    route r(Void, Void, Void)

        attrs
            key1 = "value1"
            key2 = 1234
            key3 = false

These attributes are defined and typed in a special struct named ``Route`` that
must be defined in the ``stone_cfg`` namespace. This is a special namespace
that isn't exposed to generators::

    namespace stone_cfg

    struct Route
        key1 String
        key2 Int64
        key3 Boolean
        key4 String = "hello"

As you can see, ``key4`` can be omitted from the attrs of route ``r`` because
it has a default.

A value can reference a union tag with void type::

    namespace sample

    route r(Void, Void, Void)

        attrs
            key = a

    union U
        a
        b

Route schema::

    namespace stone_cfg

    import sample

    struct Route
        key sample.U

Deprecation
-----------

You can mark a route as deprecated as follows::

    route binary_op(Arg, Void, Void) deprecated

If the route is deprecated in favor of a newer route, use ``deprecated by``
followed by the new route's name::

    route binary_op(BinaryOpArg, Result, BinaryOpError) deprecated by binary_op_v2

    route binary_op_v2((BinaryOpArg, ResultV2, BinaryOpError))

The new route ``binary_op_v2`` happens to use the same argument and error
types, but its result type has changed.

Versioning
----------

It's possible to have multiple versions of the same route. You can do so by adding an optional
version number to the end of the route name separated by a colon (``:``). The version number needs
to be a positive integer. When no version number is specified, the default value is 1, as shown
below::

    route get_metadata:2(Void, Void, Void)

The version number can also be specified in the same way when deprecating a route using
``deprecated by``::

    route get_metadata(Void, Void, Void) deprecated by get_metadata:2

Import
======

You can refer to types and aliases in other namespaces by using the ``import``
directive.

For example, we can define all of of our calculator types in a ``common``
namespace in ``common.stone``::

    namespace common

    struct BinaryOpArg
        op Operator
        left Int64
        right Int64

    union Operator
        add
        sub

    struct Result
        answer Int64

    union BinaryOpError
        overflow

Now in ``calc.stone``, we can import all of these types and define the route::

    namespace calc

    import common

    route binary_op(common.BinaryOpArg, common.Result, common.BinaryOpError)
        "Performs the requested binary operation calculation."

When referencing data types in ``common``, use the prefix ``common.``. For
example, ``common.AccountId`` and ``common.BasicAccount``.

Two namespaces cannot import each other. This is known as a circular import and
is prohibited to make generating languages like Python possible.

.. _doc:

Patch
======

You can split the definition of a struct or union across multiple files using the
``patch`` keyword.

For example, we can define ``Person`` across two different files, starting with
``public/people.stone``::

    namespace people

    struct Person
        "Describes a member of society."

        name String
            "Given name followed by surname."

Now in ``private/people.stone``, we can define additional fields::

    namespace people

    patch struct Person
        age UInt64
            "The number of years, rounded down."

Only data types that have been fully-defined elsewhere can be patched. Note that patching
can only be used to add additional fields, not mutate existing fields.

Patching can inject both required and optional fields. For required fields, it is necessary
to inject corresponding examples as well.

``public/people.stone``::

    namespace people

    struct Person
        "Describes a member of society."

        name String
            "Given name followed by surname."

        example default
            name = "Stephen Cobbe"

        example child
            name = "Ken Elkabany"

        example adult
            name = "Qiming Yuan"

``private/people.stone``::

    namespace people

    patch struct Person
        age UInt64
            "The number of years, rounded down."

        example default
            age = 30

        example child
            name = 12

        example adult
            name = 45

.. _doc:

Annotations
======

Annotations are special decorator tags that can be applied to fields in a
Stone spec. Built-in annotations correspond to actions that Stone will perform
on the field, and custom annotations can be created to mark fields that require
special processing in client code. Annotations can be stacked on top of one
another in most cases.

Currently, Stone supports the following annotations:

Omission
----------

Omission is the server-side notion of changing the API interface depending on the caller.

"Omitted" annotations are annotations that associate a field with a particular
set of caller permissions. "Caller permissions" are simply a list of raw string tags that
the server determines apply to a particular caller.

If the value of the Omitted annotation for a particular field is contained within the caller
permissions list that the server passes to Stone at serialization time, the nullability of the
field will be enforced. If not, then the field's nullability is ignored, and it will be stripped
out at serialization time.

This is useful in the case of maintaining a public/private interface for your API endpoints.
Omitted annotations help to reduce server code redundancies and complicated public/private Stone
object hierarchies.

From the client's perspective, there is only one interface, be it public, private or any other
arbitrary caller type that is defined in the Stone spec. It is the server's job to manage these
different interfaces, depending on caller type.

``public/people.stone``::

    namespace people

    struct Person
        "Describes a member of society."

        name String
            "Given name followed by surname."

        example default
            name = "Stephen Cobbe"

``private/people.stone``::

    namespace people

    annotation InternalOnly = Omitted("internal")

    patch struct Person

        sensitive_id UInt64
            @InternalOnly
            "A sensitive ID that should not be revealed publicly."

        example default
            sensitive_id = 1234

In this example, the field `sensitive_id` will only be returned for callers that have the
"internal" permission in the permissions list that the server passes into Stone at serialization time.

This helps to streamline server logic. Endpoint handlers can simply compute the full
public/private super-type, and then rely on the serialization layer to strip out the appropriate
fields, depending on the caller type.

For expensive fields, endpoint handler logic can be forked based on caller type with the understanding
that nullability will be selectively enforced, depending on caller type.

Note: as a simplifying assumption, fields can be tagged with at most one caller type.

Redaction
----------

Redaction is the act of removing sensitive data during serialization for the purpose of logging.

"Redacted" annotations are annotations that associate a field with a particular
type of redaction, either blotting out (e.g "***") or hashing. The redacting action is performed
during serialization in the context of logging. This keeps sensitive information outside of logs.
Currently, only string and numeric typed fields are eligible for redaction.

Redacted annotations accept an optional regular expression string which selectively applies the
redacting action to the part of the value to be redacted. If no regex is supplied, the entire
value is redacted.

In general, redaction is done at the field level. Aliases, however, can be marked at their definition
with a redactor tag. In this case, any field of that alias type will be redacted, so redaction will be
done at the type level.

::

    namespace people

    annotation NameRedactor = RedactedBlot("test_regex")
    annotation IdRedactor = RedactedHash()

    alias Name = String
        @NameRedactor

    struct Person
        "Describes a member of society."

        name Name
            "Given name followed by surname."

        sensitive_id UInt64
            @IdRedactor
            "A sensitive ID that should not be revealed publicly."

        example default
            name = "Stephen Cobbe"

Deprecation
----------

Deprecation here is the act of marking a field as deprecated (as opposted to marking a route as deprecated).

Deprecated fields have special warnings injected into their documentation, and can be used to generate
compile-time warnings if the field is referenced.

::

    namespace people

    annotation Deprecated = Deprecated()

    struct Person
        "Describes a member of society."

        name String
            @Deprecated
            "Given name followed by surname."

        example default
            name = "Stephen Cobbe"

Previewing
----------

Previewing here is the act of marking a field as in preview-mode (as opposted to marking a route as in preview-mode).

Preview fields have special warnings injected into their documentation, and can be used to generate
compile-time warnings if the field is referenced.

::

    namespace people

    annotation Preview = Preview()

    struct Person
        "Describes a member of society."

        name String
            @Preview
            "Given name followed by surname."

        example default
            name = "Stephen Cobbe"


Custom annotations
----------

**Note:** only the `python_types` backend supports custom annotations at this
time.

A custom annotation type, possibly taking some arguments, can be defined
similarly to structs, and then applied the same way built-in annotations are.
Note that the parameters can only be primitives (possibly nullable).

Arguments can be provided as either all positional or all keyword arguments, but
not a mix of both. Keyword arguments are recommended to avoid depending on the
order fields are listed in the custom annotation definition.

::

    namespace custom_annotation_demo

    annotation_type Noteworthy
        "Describes a field with noteworthy information"
        importance String = "low"
            "The level of importance for this field (one of 'low', 'med',
            'high')."

    annotation KindaNoteworthy = Noteworthy()
    annotation MediumNoteworthy = Noteworthy("med")
    annotation ReallyNoteworthy = Noteworthy(importance="high")

    alias ImportantString = String
        @ReallyNoteworthy

    struct Secrets
        small_secret String
            @KindaNoteworthy
        lots_of_big_ones List(ImportantString)


In client code, you can access every field of a struct marked with a certain
custom annotation by calling ``._process_custom_annotations(custom_annotation, field_path,
processor)`` on the struct. ``processor`` will then be called with three
parameters: (1) an instance of the annotation type with all the parameters
populated, (2) a string denoting the path to the field being evaluated
(i.e., for debugging purposes), and (3) the value of the field.
The value of the field will then be replaced with the return value of ``processor``.

Note that this will also affect annotated fields that are located arbitrarily
deep in the struct. In the example above, if ``secret`` is a struct of type
``Secrets``, then calling ``secret._process_custom_annotations(Noteworthy, "Secrets", processor)``
will result in ``processor`` being called once as
``processor(Noteworthy("low"), "Secrets.small_secret", secret.small_secret)`` and once as
``processor(Noteworthy("high"), "Secrets.lots_of_big_ones[i]", x)`` for each element ``x`` at
index ``i`` of ``secret.lots_of_big_ones``.

.. _doc:

Documentation
=============

Documentation strings are an important part of specifications, which is why
they can be attached to routes, structs, struct fields, unions, and union
options. It's expected that most elements should be documented. It's not
required only because some definitions are self-explanatory or adding
documentation would be redundant, as is often the case when a struct field
(with a doc) references a struct (with a doc).

Documentation is accessible to generators. Code generators will inject
documentation into the language objects that represent routes, structs, and
unions. Backends for API documentation will find documentation strings
especially useful.

.. _doc-refs:

References
----------

References help generators tailor documentation strings for a target
programming language.

References have the following format::

    :tag:`value`

Supported tags are ``route``, ``type``, ``field``, ``link``, and ``val``.

route
    A reference to a route. The value should be the name of the route. Code
    generators should reference the class or function that represents the route.
type
    A reference to a user-defined data type (Struct or Union). The value should
    be the name of the user-defined type.
field
    A reference to a field of a struct or a tag of a union. If the field being
    referenced is a member of a different type than the docstring, then use the
    format `TypeName.field_name`. Otherwise, use just the field name as the
    value.
link
    A hyperlink. The format of the value is ``<title...> <uri>``, e.g.
    ``Stone Repo https://github.com/dropbox/stone``. Everything after the
    last space is considered the URI. The rest is treated as the title. For
    this reason, you should ensure that your URIs are
    `percent encoded <http://en.wikipedia.org/wiki/Percent-encoding>`_.
    Backends should convert this to a hyperlink understood by the target
    language.
val
    A value. Supported values include ``null``, ``true``, ``false``, integers,
    floats, and strings. Backends should convert the value to the native
    representation of the value for the target language.

Line Continuations
==================

Implicit line continuations are supported for expressions in between
parentheses as long as they are at an additional indentation. For example::

    route binary_op(
        BinaryOpArg,
        Result,
        BinaryOpError)

Grammar
=======

Specification::

    Spec ::= Namespace Import* Definition*
    Namespace ::= 'namespace' Identifier
    Import ::= 'import' Identifier
    Definition ::= Alias | Route | Struct | Union
    Alias ::= 'alias' Identifier '=' TypeRef (NL INDENT Doc DEDENT)?

Struct::

    Struct ::= 'struct' Identifier Inheritance? NL INDENT Doc? Subtypes? Field* Example* DEDENT
    Inheritance ::= 'extends' Identifier
    SubtypeField ::= Identifier TypeRef NL
    Subtypes ::= 'union' NL INDENT SubtypeField+ DEDENT
    Default ::= '=' Literal
    Field ::= Identifier TypeRef Default? (NL INDENT Doc DEDENT)?

Union::

    Union ::= 'union' Identifier NL INDENT (VoidTag|Tag)* DEDENT
    VoidTag ::= Identifier '*'? (NL INDENT Doc DEDENT)?
    Tag ::= Identifier TypeRef (NL INDENT Doc DEDENT)?

Route::

    Route ::= 'route' Identifier (':' VersionNumber)? '(' TypeRef ',' TypeRef ',' TypeRef ')' (NL INDENT Doc DEDENT)?

Type Reference::

    Attributes ::= '(' (Identifier '=' (Literal | Identifier) ','?)*  ')'
    TypeRef ::= Identifier Attributes? '?'?

Primitives::

    Primitive ::= 'Bytes' | 'Boolean' | 'Float32' | 'Float64' | 'Int32'
                  | 'Int64' | 'UInt32' | 'UInt64' | 'String' | 'Timestamp'

Composites::

    Composite ::= 'List'

Basic::

    Identifier ::= (Letter | '_')? (Letter | Digit | '_')* # Should we allow trailing underscores?
    Letter ::=  ['A'-'z']
    Digit ::=  ['0'-'9']
    Literal :: = BoolLiteral | FloatLiteral | IntLiteral | StringLiteral
    BoolLiteral ::= 'true' | 'false'
    FloatLiteral ::=  '-'? Digit* ('.' Digit+)? ('E' IntLiteral)?
    IntLiteral ::=  '-'? Digit+
    StringLiteral ::= '"' .* '"' # Not accurate
    VersionNumber ::= ['1'-'9'] Digit*
    Doc ::= StringLiteral # Not accurate
    NL = Newline
    INDENT = Incremental indentation
    DEDENT = Decremented indentation

TODO: Need to add additional information about handling of NL, INDENT, DEDENT,
and whitespace between tokens. Also, the attrs section of Routes and
examples (+ lists).
