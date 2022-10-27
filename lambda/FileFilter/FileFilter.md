

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
                void eat() {
                    System.out.println("Hello world!");
                }
            };
            person.speak(); // print Hello world!
        }
    }  
```

Java était donc déja capable d'implémenter une classe ou une interface directement avec les `classes anonymes` et ça avant Java 8 et les Lambdas ! 😮

Prenons maintenant un exemple d'implémentation `FileFilter` ajouté à la version 1.2 (1998) de Java, une simple interface de `java.io`:

```java
/* java.io.FileFilter.java */
interface FileFilter{
    boolean accept(File pathname)
}
```

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

Après avoir créer une implémentation, il est possible de l'utiliser pour la passer à la méthode `java.io.File.listFiles`:

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

 `listFiles` va utiliser le comportement défini dans notre implémentation, dans ce cas précis il va vérifier chacun des fichier dans le répertoire courant pour s'assurer qu'ils ont l'extension `.java`, si c'est `true` il va ajouter le nom au tableau de `File` et ensuite les afficher dans la console:

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


Pour l'utiliser l'implémentation directement: 

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

Il faut savoir qu'un/une développeur/développeuse passe beaucoup plus de temps à lire du code qu'à en écrire! Il est donc important de produire du code facile à lire, à écrire et à éditer, cela pour va rendre la vie d'un/une développeur/développeuse plus agréable 😄 et aussi augmenter la maintenabilitée d'une application ! 📖

C'est pourquoi, nous avons besoin d'outils plus moderne pour produire du code plus concis.
Donc si je dois répondre à la question: 
- *Ca sert à quoi les lambdas ?*

**la réponse est :** les lambdas sont juste un moyen d'implémenter des interfaces/classes tout en facilitant l'écriture et la lisibilitée comme la maintenabilitée du code: 

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
- L'`operateur fléche` **:** `->`
- Les `closures` aussi appelé les `méthodes anonymes` **:** `() -> {System.out.println("Java");}`


*Lambda expressions sont très populaire mais relativement nouvelles dans l'univer Java mais pas dans le monde de la programmation car elles était déja utilisé avec le langage LISP dans les années soixantes.*

*Il existe une différence entre les classes anonymes et les lambdas, les lambda ne peuvent pas avoir d'état (champs/membres) quand les classes anonymes peuvent en avoir un. C'est logique car car les lambdas sont une sorte de programamtion fonctionnelle et non pas Programmation Orienté Objet*




## English 🇬🇧

# Anonymous classes and FileFilter 📁

**Lambda expression is a feature introduced in Java 8 *(JDK8 - JSR 335)***



*There is a difference between the anonymous classes and the lambda, the lambdas can't have state (fields) where anonymous interfaces can have state. This makes sense because the lambda expressions are a form of functional programming, rather Object Oriented Programming.*