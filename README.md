# Task-List-Kata
NTUT 112-2 Software Architecture Lesson

## HW3

### Refactored parts
- Use 4 layers
  - Add TaskListIO under io
    - Dependency injection for IO of TaskListApp
  - Add command controllers and command presenter under controllers
    - CommandController
      - Create each controller and corresponding command with task list specified
    - CommandPresenter
      - Process the output of each command execution and return to TaskListIO
  - Place commands under use cases
  - Place Task, Project and TaskList under entity
    
### Notes
- Tried to avoid dependencies from inner to outer layer
- Tried to avoid implicit dependencies
  - still exists in controllers that do not interact with TaskList
  - ShowCommand implicitly depends on Project and Task
- Ensured no data member is extraneous for the class itself
- Ensured that use cases are stateless
