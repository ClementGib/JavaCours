# FileFilter 📁 and anonymous classes 😐

# Languages

[Français](#français-)
&
[English](#english-)


## Français 🇫🇷
**Lambda expression est une fonctionnalité ajouté dans Java 8 *(JDK8 - JSR 335)***


Avant d'entrer dans la définition de ce qu'est une lambda expression, il faut comprendre pourquoi cette fonctionnalité a été ajouté à Java 8 car elle ne permettent pas vraiment de faire quelque chose qu'il était impossible de faire auparavant avec des `classes anonymes`.

Prenons l'exemple de `FileFilter`, une simple interface de `java.io`

```java
/* java.io.FileFilter.java */
interface FileFilter{
    boolean accept(File pathname)
}
```

Cette interface est généralement utilisé pour la method `listFiles(FileFilter)` de `java.io`.

Essayons de créer une implémentation de FileFiler :

```java
/* JavaFileFilter.java */
public class JavaFileFilter implements FileFilter{

    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".java");
    }
}
```

Il est ensuite possible d'utiliser l'implémentation pour la passer à la méthode `java.io.File.listFiles` qui va utiliser le comportement défini dans notre implémentation pour dans ce cas précis lister chaque fichier ayant l'extension java dans le répertoire courant pour les afficher dans la console.

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

Il est toutefois possible d'implémenter une interface fonctionelle sans créer une classe externe à l'aide des `classes anonymes`:

```java
/* FileFilterTest.java */
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };
```
Et donc de directement utiliser l'implémentation de la `classe anonyme`:

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
Ce block de code est tout à fait valide toutefois il est un peu contraignant à écrire et difficile à lire.
Une développeur passe beaucoup plus de temps à lire du code que à en écrire, c'est pourquoi le code doit être facile à lire et à écrire pour rendre la vie d'un développeur plus agréable 😄

C'est pourquoi nous avons besoin d'outils plus moderne pour les développeur, si je dois répondre à la question: "Ca sert à quoi les lambdas si ont pouvait déja faire la même chose avant Java 8 ?" la réponse est :
- les lambdas sont juste un moyen d'implémenter des interface anonyme tout en facilitant l'écriture et la lisibilitée.

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

L'implémentation peut se faire en toute simplicité grâce à l'operateur fléche `->` *(arrow operator)*



*Lambda expressions sont très populaire mais relativement nouvelles dans l'univer Java mais pas dans le monde de la programmation car elles était déja utilisé avec le langage LISP dans les années soixantes.*


## English 🇬🇧
Lambda expression is a feature introduced in Java 8 *(JDK8 - JSR 335)*