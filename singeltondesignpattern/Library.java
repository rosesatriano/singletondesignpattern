package singeltondesignpattern;

import java.util.HashMap;

/**
 * This class represents a library which has a map of books. You can only create
 * one library. In this class we can check to see if we have an existing library,
 * or we can create one. The class can check out a book and check in a book. 
 * @author rosesatriano
 */
public class Library {
    private HashMap<String,Integer> books = new HashMap<String,Integer>();
    private static Library library;

    /**
     * This private method ensures that we do not create another library.
     */
    private Library(){}

    /**
     * This method checks to see whether we have an existing library. If we do not 
     * have a library, then we will create one. 
     * @param library is the object of Library which is the instance of our singular
     * library that we are working within
     * @return This returns library which is our only library that we are working in.
     */
    public static Library getInstance(){
        if(library == null){
            System.out.println("Creating our Library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }

    /**
     * In this method, we are performing the action of checking a book out of the 
     * library. We initially check out hashmap books to see if we have the given 
     * bookName, which is just checking if the book exists. If we do, we will set 
     * a book count value to the number set with the book name, which represents 
     * how many books of that name are there. If our book count is above zero, 
     * then we will take out the book from the library which subtracts 1 from the 
     * set value for that book. We will then tell the user that the book was 
     * successfully checked out. If our book count for that book is zero, then we
     * will let the user know that the book is not in stock. 
     * @param bookCount This represents the number of the given book in the library.
     * @param bookName This represents the given name to the book we are referring to. 
     * @return We either return true, which is when there is a book to checkout, or
     * we will return false if the book is not in stock. 
     */
    public boolean checkoutBook(String bookName){
        if(books.containsKey(bookName)){
            int bookCount = books.get(bookName);
            if(bookCount > 0){
                books.put(bookName, bookCount - 1);
                System.out.println(bookName+" was successfully checked out");
             return true;
            }else{
                System.out.println("Sorry "+bookName+" is not in stock");
            }
        }
        return false;
    }

    /**
     * In this method, we are checking the given book back into our library. We will
     * first check to see if that book is in our hashmap books. If we do, then we will
     * increase the number of that book we have in the library. If we do not already
     * have that book, then we will add that book to the hashmap. We will then inform
     * the user that the book was added to the library.
     * @param bookName This represents the given name to the book we are referring to.
     * @param numToAdd This refers to the number of books that we are adding to our
     * book count in our hashmap, which is just the set value for the key. 
     */
    public void checkInBook(String bookName, int numToAdd){
        if(books.containsKey(bookName)){
            int bookCount = books.get(bookName);
            books.put(bookName, bookCount + numToAdd);
        }else{
            books.put(bookName, numToAdd);
        }
        System.out.println(bookName+" was added to the library");
    }

    /**
     * In this method, we are just displaying our inventory of books within the 
     * library. We need to loop through the hashmap to print out the key, which is 
     * the booke name, and print out the value, which is the book count. 
     */
    public void displayBooks(){
        System.out.println("Inventory: ");
        for(HashMap.Entry<String,Integer> entry: books.entrySet()){
            System.out.println("- "+entry.getKey()+", copies: "+entry.getValue());
        }
    }
}
