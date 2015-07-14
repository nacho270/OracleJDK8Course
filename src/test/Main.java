package test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    final List<BigDecimal> prices = Arrays.asList(
        new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
        new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
        new BigDecimal("45"), new BigDecimal("12"));
    
    final BigDecimal totalOfDiscountedPrices =
        prices.stream()
            .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
            .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    prices.forEach(new Consumer<BigDecimal>() {
      @Override
      public void accept(BigDecimal t) {

      }
    });
//    prices.forEach(precio -> System.out.println(precio));
    prices.forEach(System.out::println);
    final Function<String, Predicate<String>> startsWithLetter =
        (String letter) -> {
          Predicate<String> checkStartsWith =
              (String name) -> name.startsWith(letter);
          return checkStartsWith;
        };
//    final Function<String, Predicate<String>> startsWithLetter =
//        (String letter) -> (String name) -> name.startsWith(letter);
  }
  
  public static void pickName(final List<String> names, final String startingLetter) {
    final Optional<String> foundName =
      names.stream()
      .filter(name ->name.startsWith(startingLetter))
      .findFirst();
      System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
   }
}
