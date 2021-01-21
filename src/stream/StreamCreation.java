package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamCreation {

	public static void main(String[] args) {

		System.out.println("1. Creating Empty Stream, using Stream.empty()");
		Stream<String> stream= Stream.empty();
		stream.forEach(System.out::println);
		
		System.out.println("2. Creating Stream of Array, using Arrays.stream(array)");
		String [] names= {"Sopan", "Manoj", "Kisan", "ketan", "Aniket"};
		Stream<String> nStream= Arrays.stream(names);
		nStream.forEach(System.out::println);
		
		System.out.println("3. Creating Stream of Array with start and end index, using Arrays.stream(array, start, end)");
		Arrays.stream(names, 1, 4).forEach(System.out::println);
		
		System.out.println("4. Creating Stream by StreamBuilder");
		Stream<String> bStream= Stream.<String>builder().add("Sopan").add("manoj").build();
		bStream.forEach(System.out::println);
		
		System.out.println("5. Creating Stream using Stream.generate().limit");
		Stream.generate(() -> "Sopan").limit(5).forEach(System.out::println);
		// if we are not mentionaning limit here this will become infinite stream, OOM will happen
	
		System.out.println("6. Creating Stream using Stream.iterate().limit");
		Stream.iterate(30, n -> n=n+2).limit(20)
		.forEach(System.out::println);
		
		System.out.println("7. Creating Stream of Primitives using range() and rangeClosed()");
		//As Stream<T> is generic type we can create stream of primitive types, so java has 
		//IntStream, LongStream, DoubleStream interfaces in java.util.stream package
		//range(startInclusive, endExclusive)
		//rangeClosed(startInclusive, endInclusive)
		IntStream.range(1,10).forEach(System.out::println);
		LongStream.rangeClosed(1,10).forEach(System.out::println);
		
		System.out.println("8. Creating Stream of Primitives using Random class");
		Random random= new Random();
		DoubleStream doubleStream= random.doubles(10);
		doubleStream.forEach(n-> System.out.println(n));
		random.ints(10).forEach(n-> System.out.println(n));
		
		System.out.println("9. Creating Stream of String using myString.chars()");
		String myString= new String("SOpan BHutekar");
		myString.chars().forEach(n->System.out.println((char)n));
		
		System.out.println("10. Creating Stream of String using Pattern.compile().splitAsStream()");
		Pattern.compile(",").splitAsStream("SOpan,santosh,rajesh,muffi")
		.forEach(System.out::println);
		
		System.out.println("11. Creating Stream of String from File using Files.lines()");
		Path path =Paths.get("C://Users/sbhutek/sample.txt");
		try {
			Stream<String> linesFromFiles= Files.lines(path);
			linesFromFiles.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
