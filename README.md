# Task-List-Kata
NTUT 112-2 Software Architecture Lesson

## HW4

### Refactored parts
- 4 layers
  - **IO**
    - _TaskListIO_
      - Dependency injection for IO of TaskListApp
    - _TaskListApp_
      - Depends on _CommandController_, _CommandPresenter_ and _TaskListIOInterface_ to work
  - **Controllers**
    - _CommandController_
      - Create each controller and corresponding command with task list specified
    - _CommandPresenter_
      - Process the output of each command execution and return to _TaskListIO_
  - **Use cases**
    - commands: every command use cases that may be used
    - _TaskListCommand_ `#new`
      - works between _CommandController_ and commands
  - **Entity**
    - _Task_
    - _Project_
    - _TaskList_
    
### Notes
- Avoid dependencies from inner to outer layer
- Avoid implicit dependencies
- No data member is extraneous for the class itself
- Use cases should be stateless
- Controllers should not know the exact command to create `#new`
- Avoid breaking encapsulation `#new`
  - i.e. `getProjects()` in _TaskList_, `getTasks` in _Project_ that return the _Task_ and _Project_ directly
  - Now _TaskList_ can only get the information of a _Task_ by calling public methods provided by _Project_, which depend on public methods provided by _Task_ itself. 


### TO-DO
- Possible ways for the _TaskListApp_ to depend on fewer entities?
