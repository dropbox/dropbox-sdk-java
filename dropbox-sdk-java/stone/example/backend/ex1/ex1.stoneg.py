from stone.backend import CodeBackend


class ExampleBackend(CodeBackend):
    def generate(self, api):
        """Generates a file that lists each namespace."""
        with self.output_to_relative_path('ex1.out'):
            for namespace in api.namespaces.values():
                self.emit(namespace.name)
