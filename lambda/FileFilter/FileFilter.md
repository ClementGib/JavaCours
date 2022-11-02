

[Français](#français-)
&
[English](#english-)


## Français 🇫🇷

# Les classes anonymes et FileFilter 📁


**Lambda expression est une fonctionnalité ajouté dans Java 8 *(JDK8 - JSR 335)***


- *Qu'est ce qu'une lambda expression ?*

Avant de répondre à cette question, il faut savoir ce qu'est une `classe anonyme`. Une `classe anonyme` est moyen de déclarer une nouvelle classe sans lui donner de nom et en créant une instance en même temps.

```java
    abstract class Person {  
      abstract void speak();  
    }

    class testAnonymousClass {  
        public static void main(String args[]){
            Person person = new Person() {
                void speak() {
                    System.out.println("Hello world!");
                }
            };
            person.speak(); // print Hello world!
        }
    }  
```

Java était donc déja capable d'implémenter une classe ou une interface directement avec les `classes anonymes` et ça avant Java 8 et les Lambdas ! 😮


<br>
Prenons maintenant un exemple d'implémentation avec `FileFilter` une interface ajouté à la version 1.2 de Java (1998) dans le package de `java.io`:

```java
/* java.io.FileFilter.java */
interface FileFilter{
    boolean accept(File pathname)
}
```

<br>
L'interface `FileFilter` est principalement prévu pour être utilisé avec la méthode `listFiles(FileFilter)` de `java.io`:

```java
/* JavaFileFilter.java */
public class JavaFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
```

<br>
Après avoir créer une implémentation, il est possible de la passer à la méthode `java.io.File.listFiles` en tant qu'argument:

```java
/* FileFilterTest.java */
    public static void main(String[] args) {
        // Using personnal class that implements the interface
        JavaFileFilter fileFilter = new JavaFileFilter();

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
```

 `listFiles` va utiliser le comportement défini dans notre implémentation, dans ce cas précis il va vérifier chacun des fichiers dans le répertoire courant pour s'assurer qu'ils ont l'extension `.java`, si c'est `true` il va ajouter le nom au tableau de `File` pour ensuite l'afficher dans la console.


<br>
Il est toutefois possible d'implémenter une interface fonctionelle sans créer une classe externe, grâce justement aux `classes anonymes`:

```java
/* FileFilterTest.java */
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
```


<br>
Pour utiliser l'implémentation directement: 

```java
/* FileFilterTest.java */
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
```
Ce block de code est tout à fait valide toutefois il est un peu contraignant à écrire et difficile à lire. 😞

Il faut savoir qu'un/une développeur/développeuse passe beaucoup plus de temps à lire du code qu'à en écrire! Il est donc important de produire du code facile à lire, à écrire et à éditer, cela va rendre la vie d'un/une développeur/développeuse plus agréable 😄 et aussi augmenter la maintenabilitée d'une application ! 📖

C'est pourquoi, nous avons besoin d'outils plus moderne pour produire du code plus concis.
Donc si je dois répondre à la question **Ca sert à quoi les lambdas ?**

**les lambdas sont juste un moyen d'implémenter des interfaces ou des classes tout en facilitant l'écriture et lisibilitée mais aussi maintenabilitée du code.**

<br>

Implémentation à l'aide d'une lambda:

```java 
/* FileFilterTest.java */
    public static void main(String[] args) {
        FileFilter fileFilter = (File file) -> file.getName().endsWith(".java");

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
```

L'implémentation peut se faire en toute simplicité grâce à :
- lambda expressions appelé aussi des `méthodes anonymes`
- Elle utilise donc l'`operateur fléche` **:** `->`
- Et peut utiliser des `closures` permettant d'entourer un scope `() -> {System.out.println("Java");}`


**TIPS:**

- *Lambda expressions sont très populaire mais relativement nouvelles dans l'univer Java. Toutefois elles ne sont pas nouvelles dans le monde de la programmation car elles était déja utilisé avec le langage LISP dans les années soixantes.*
- *Il existe une différence entre les classes anonymes et les lambdas, les lambda ne peuvent pas avoir d'état (champs/membres) quand les classes anonymes peuvent en avoir un. C'est logique car car les lambdas sont une sorte de programamtion fonctionnelle et non pas Programmation Orienté Objet*




## English 🇬🇧

# Anonymous classes and FileFilter 📁

**Lambda expression is a feature introduced in Java 8 *(JDK8 - JSR 335)***

- *What is a lambda expression ?*

Before answering this question, we need to know what is a `anonymous class`. A `anonymous class` is a way to declare a new class without giving it a name and create an instance at the same time.

```java
    abstract class Person {  
      abstract void speak();  
    }

    class testAnonymousClass {  
        public static void main(String args[]){
            Person person = new Person() {
                void speak() {
                    System.out.println("Hello world!");
                }
            };
            person.speak(); // print Hello world!
        }
    }  
```

Java was already able to implements a class or an interface directly with the `anonymous classes` and this before Java 8 and the lambdas ! 😮

<br>

Let's take an example of implementation with `FileFilter` an interface added in the 1.2 version of Java (1998) into the `java.io` package.

```java
/* java.io.FileFilter.java */
interface FileFilter{
    boolean accept(File pathname)
}
```

<br>
The `FileFilter` interface is mainly intended to be used  with the `listFiles(FileFilter)` method of `java.io`:

```java
/* JavaFileFilter.java */
public class JavaFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
```

<br>
After creating an implementation, it is possible to pass it to `java.io.File.listFiles` method as an argument.

```java
/* FileFilterTest.java */
    public static void main(String[] args) {
        // Using personnal class that implements the interface
        JavaFileFilter fileFilter = new JavaFileFilter();

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
```

`listFiles` will use the behavior defined in our implementation, in this precise case it will check each files in the current directory to ensure that it has the `.java` extension, if it's `true` it will add the name of the file in the array of `File` to display it in the console after.


<br>
This is however possible to implement an functional interface without create a external class, thanks to `anonymous classes`. 

```java
/* FileFilterTest.java */
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };
```


<br>
To use directly the implementation:

```java
/* FileFilterTest.java */
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
```

This code block is completly valid however this is a bit constraining to write and hard to read.😞

You have to know that a developer spent more time to read code that to write it! Therefore it is important to produce a easier code to read, to write and to edit, that will make the developer life easier and more enjoyable 😄 and increase the application maintainability too !📖

This is why, we need more modern tools to produce more consice code.
If I have to answer to the question  **What is lambda made for ?**

**The lambdas are just a way to implement interfaces or classes while facilitate reading and readability but code maintenability too.**

<br>

Implementation with a lambda:

```java 
/* FileFilterTest.java */
    public static void main(String[] args) {
        FileFilter fileFilter = (File file) -> file.getName().endsWith(".java");

        File directory = new File(".");
        File[] javaFiles = directory.listFiles(fileFilter);
        for (File javaFile : javaFiles) {
            System.out.println(javaFile.getName());
        }
    }
```

The implementtion can be done easily with:
- lambda expressions called `anonymous methods` too
- It use the arrow operator ` **:** `->`
- And can use the `closures` or not, that allow to enclosing scope `() -> {System.out.println("Java");}`


**TIPS:**

- *Lambda expressions are very popular but relatively new in the Java ecosystem, However it is not new and the programming world because it was already used in the LISP language during the sixties.*
- *There is a difference between the anonymous classes and the lambda, the lambdas can't have state (fields) where anonymous interfaces can have state. This makes sense because the lambda expressions are a form of functional programming, rather Object Oriented Programming.*




