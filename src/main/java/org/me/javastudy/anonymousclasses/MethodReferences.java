package org.me.javastudy.anonymousclasses;

public class MethodReferences {

    public static void main(String[] args){
        MethodReferences methodReferences = new MethodReferences();
        methodReferences.examples();
    }
    private interface Addition {
        public Integer addition(Integer a, Integer b);
    }

    private interface StringStuff {
        public String combine(String a, String b);
    }

    private interface StringStuffAgain {
        public char[] getArray(String a);
    }

    private class Maths {

        public Integer addition(Integer a, Integer b){
            return a+b;
        }

        @Override
        public String toString(){
            return "I'm a maths object bro";
        }
    }

    private interface BuildObject<T> {
        public T buildObject();
    }
    public void examples(){
        System.out.println("Method references are syntactical abstractions for lambda expressions");
        System.out.println("If all a lambda expression does is make a call to an already existing method, then it can be written as a method reference");
        System.out.println("There are 4 different types of method calls in a lambda expression that can be rewritten as a method reference");

        //1) Reference to a static method
        System.out.println("1) Reference to a static method");
        Addition additionMethod = (a,b) -> MethodReferenceExamples.addTwoNumbers(a,b);
        //The lambda expression can be rewritten as:
        additionMethod = MethodReferenceExamples::addTwoNumbers;
        System.out.println(additionMethod.addition(1,2));

        //2) Reference to an instance method of a particular object
        System.out.println("2) Reference to an instance method of a particular object");
        Maths mathsObject = new Maths();
        additionMethod = mathsObject::addition;
        System.out.println(additionMethod.addition(1,2));

        //3) Reference to an instance method of an arbitrary object of a particular type
        System.out.println("3) Reference to an instance method of an arbitrary object of a particular type (i.e. if the arguments are of the same type specify the type and the method you want to use");
        StringStuff stringCombine = String::concat;
        System.out.println(stringCombine.combine("method"," reference"));

        System.out.println("Another example with one argument instead of two");
        StringStuffAgain stringToArray = String::toCharArray;
        char[] charArray = stringToArray.getArray("method reference");
        for(int i = 0; i < charArray.length; i++)
            System.out.println(charArray[i]);

        //4) Reference to a constructor
        System.out.println("4) Reference to a constructor method");
        BuildObject<Maths> mathsBuildObject = Maths::new;
        Maths builtObject = mathsBuildObject.buildObject();
        System.out.println(builtObject.toString());
    }




}
