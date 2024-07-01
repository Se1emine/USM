class Manager:
    def __init__(self, project=None):
        self._project = project

    def project(self):
        return self._project

    @project.setter
    def project(self, project_name):
        self._project = project_name

    def getProject(self):
        return self.project

    def setProject(self, project_name):
        self.project = project_name


manager1 = Manager()
manager2 = Manager("My First Project")

print(f"manager1.project: {manager1.project}")
print(f"manager2.project: {manager2.project}")

manager1.setProject("New Project Name")

print(f"manager1.project: {manager1.project}")
print(f"manager2.project: {manager2.project}")
