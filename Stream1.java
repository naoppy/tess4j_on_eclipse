import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Stream1 {
	public static void main(String[] args) {
		//showList();
		//chengeList();
		//kensaku();
		
	}
	public static void chengeList() {
		final List<String> uppercaseNames = new ArrayList<String>();
		final List<String> friends = Arrays.asList("a","b","c");

		//古いコード
		for(String name : friends) {
			uppercaseNames.add(name.toUpperCase());
		}
		//Stream mapとforEach
		friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
		System.out.println(uppercaseNames);
		//流暢な関数
		friends.stream()
			   .map(name -> name.toUpperCase())
			   .forEach(name -> System.out.print(name + " "));
		System.out.println();
		//メソッド参照
		friends.stream()
			   .map(String::toUpperCase)
			   .forEach(System.out::print);
	}
	public static void showList() {

		final List<String> friends = Arrays.asList("A","B","C");

		//古いコード
		for(int i = 0; i < friends.size(); i++) {
			System.out.println(friends.get(i));
		}
		//美しくない
		for(String name : friends) {
			System.out.println(name);
		}
		//Iterable.forEachにConsumerを渡す
		friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.println(name);
			}
		});
		//匿名クラスではなくラムダ式を使っている
		friends.forEach((final String name) -> System.out.println(name));
		//型推論を使って省略
		friends.forEach(name -> System.out.println(name));
		//メソッド参照を使う
		friends.forEach(System.out::println);
	}
	public static void kensaku() {
		List<String> startWithN = new ArrayList<String>();
		final List<String> friends = Arrays.asList("note","Native","ignore");
		//古いコード
		for(String name : friends) {
			if(name.startsWith("N")) {
				startWithN.add(name);
			}
		}
		//Stream filterとcollect
		startWithN =
		friends.stream()
			   .filter(name -> name.startsWith("N"))
			   .collect(Collectors.toList());
		System.out.println(String.format("Found %d names", startWithN.size()));

	}

}
