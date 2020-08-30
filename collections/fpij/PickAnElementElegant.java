/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package fpij;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import static fpij.Folks.friends;

public class PickAnElementElegant {
  public static void pickName(
    final List<String> names, final String startingLetter) {
      
    final Optional<String> foundName = 
      names.stream()
           .filter(name ->name.startsWith(startingLetter))
           .findFirst();
      
    System.out.println(String.format("A name starting with %s: %s",
      startingLetter, foundName.orElse("No name found")));
  }

  public static void main(final String[] args) {
    pickName(friends, "N");
    pickName(friends, "Z");

    final Optional<String> foundName = 
      friends.stream()
             .filter(name ->name.startsWith("N"))
             .findFirst();

    foundName.ifPresent(name -> System.out.println("Hello " + name));
  }
}
