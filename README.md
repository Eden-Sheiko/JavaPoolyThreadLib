# JavaPoolyThreadLib

# Pooly Multithreading Library in Java

## 📢 Important Note
Changes may be introduced into this document during meetings until the end of the semester. Therefore, ensure that your project meets the requirements of this document by the end of this semester. Any questions regarding the interpretation of this document should be posted in the course forum. 

## 📖 Introduction
The final project involves developing an imaginary pooly multithreading library in Java. The library includes the `ThreadsPool` class, which assists in managing multiple threads as a pool. The library should be packaged into a single JAR file named `pooly.jar`.

## 📦 Package: il.ac.hit.pooly
The classes and interfaces should be packaged under `il.ac.hit.pooly`. This package should include the `ThreadsPool` class and the `Task` interface at a minimum.

### 📄 The il.ac.hit.pooly.Task Interface
This interface should include the following abstract methods:

```java
public interface Task {
    void perform();
    void setPriority(int level);
    void getPriority();
}
```
## 📄 The il.ac.hit.pooly.ThreadsPool Class
This class should include a constructor (with a single parameter) that allows specifying the number of Thread objects the pool will manage, and a method named submit for submitting a Task object to be managed by the ThreadsPool object.
```
public void submit(Task task) {
    // implementation goes here
}
```
The ThreadsPool object should execute the submitted tasks based on their priorities.

##🧪 Unit Tests
The project should include unit tests developed with JUnit. Use the existing wizards in IntelliJ. This video explains how to develop unit tests with JUnit.

## 💻 Code Style
The Java code should follow this style guide. If you have any questions regarding this style guide, please post them in the course forum.

## 🚀 Submission Guidelines
Follow these guidelines for submitting this project:

1. Develop the project with IntelliJ IDE. Both ultimate and community versions are acceptable.
2. Create a short video (up to 60 seconds) showing how the project runs. Upload it as an unlisted video on YouTube. It's OK to create a video without sound.
3. Pack the entire project into a ZIP file and upload it to the submission box (to be opened on Moodle) along with the JAR file and a PDF file.
4. The PDF file should include all your code files. Make sure that lines are not broken and that the alignment is to the left.
The PDF file should also include:
* The first name and last name of the development team manager.
* Full details (First name, Last name, ID, Mobile Number, Email Address) of each team member.
* A clickable link to the video you created.
5. The team manager should submit the files (ZIP, JAR, PDF) in the assignment box on Moodle.
The deadline for submitting this project is _____.

## 🔄 Change Log
21.5.2023: The getPriority method was added to the Task interface.
