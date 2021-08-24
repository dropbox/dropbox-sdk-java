MYPY = False
if MYPY:
    import typing  # noqa: F401 # pylint: disable=import-error,unused-import,useless-suppression

try:
    # Works for Py 3.3+
    from unittest.mock import DEFAULT, Mock
except ImportError:
    # See https://github.com/python/mypy/issues/1153#issuecomment-253842414
    from mock import DEFAULT, Mock  # type: ignore

from stone.backend import Backend

def _mock_output(backend):
    # type: (Backend) -> typing.Callable[[], str]
    """
    Mock out Backend's .emit function, and return a list containing all params
    emit was called with.
    """
    recorded_output = []  # type: typing.List[str]

    output_buffer_to_string = backend.output_buffer_to_string

    def record_output():
        recorded_output.append(output_buffer_to_string())
        return DEFAULT

    backend.output_buffer_to_string = Mock(  # type: ignore
        wraps=output_buffer_to_string,
        side_effect=record_output)

    def get_output():
        backend.output_buffer_to_string = output_buffer_to_string
        return recorded_output[0] if recorded_output else ''

    return get_output
