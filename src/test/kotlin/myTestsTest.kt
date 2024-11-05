import org.example.myTests
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class myTestsTest {
    private val tests: myTests = myTests()

    private val stack: myTests.Stack<Int> = myTests.Stack()

    @BeforeEach
    fun setUp() {}

    @AfterEach
    fun tearDown() {}

    //region BEGGINER LEVEL
    @Test
    fun testSum() {
        val expected = 42
        val actual = tests.sum(19, 23)
        assertEquals(expected, actual)
    }

    @Test
    fun capitalizeSentence() {
        val expected = "Hello World Man !"
        val actual = tests.capitalizeSentence("hello world man !")
        assertEquals(expected, actual)
    }

    @Test
    fun countDown() {
        val expected = listOf(5, 4, 3, 2, 1, 0)
        val actual = tests.countDown(5)
        assertEquals(expected, actual)
    }

    @Test
    fun getOddNumbers() {
        val expected = listOf(1, 3, 5, 7, 9)
        val actual = tests.getOddNumbers((0..10).toList())
        assertEquals(expected, actual)
    }

    @Test
    fun containsRange() {
        val list1 = 5..7
        val list2 = 5..7
        assertTrue(tests.containsRange(list1, list2))
    }

    @Test
    fun getGetOddNumbers1() {
        val expected = listOf(1, 3, 5, 7, 9)
        val actual = tests.getOddNumbers1((0..10).toList())
        assertEquals(expected, actual)
    }

    @Test
    fun linearSearch() {
        val list = listOf("a", "b", "c", "d", "e")
        val target = "c"
        val expected = 2
        val actual = tests.linearSearch(list, target)
        assertEquals(expected, actual)
    }

    @Test
    fun formatTrainRoute1() {
        val route = listOf("A", "B", "C", "D", "E")
        val expected = "Train is calling at A, B, C, D and E"
        val actual = tests.formatTrainRoute1(route)
        assertEquals(expected, actual)
    }
    //endregion

    //region INTERMEDIATE LEVEL

    @Test
    fun isAnagram() {
        val str1 = "listen"
        val str2 = "silent"
        val expected = true
        val actual = tests.isAnagram(str1, str2)
        assertEquals(expected, actual)
    }

    @Test
    fun isPermutationPalindrome() {
        val str = "Tact Coa"
        val expected = true
        val actual = tests.isPermutationPalindrome(str)
        assertEquals(expected, actual)
    }

    @Test
    fun maxOccurringChar() {
        val str = "Hello World"
        val expected = "l"
        val actual = tests.maxOccurringChar(str)
        assertEquals(expected, actual)
    }

    @Test
    fun reverseString() {
        val str = "Hello World"
        val expected = "dlroW olleH"
        val actual = tests.reverseString(str)
        assertEquals(expected, actual)
    }

    @Test
    fun countTheVowels() {
        val str = "Hello World"
        val expected = 3
        val actual = tests.countTheVowels(str)
        assertEquals(expected, actual)
    }

    @Test
    fun reverseInt() {
        val num = -12345
        val expected = -54321
        val actual = tests.reverseInt(num)
        assertEquals(expected, actual)
    }

    @Test
    fun getStepsGenerator() {
        val expected = listOf("#  ", "## ", "###")
        val actual = tests.stepsGenerator(3)
        assertEquals(expected, actual)
    }

    @Test
    fun fizzBuzz() {
        val expected = listOf("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")
        val actual = tests.fizzBuzz(15)
        assertEquals(expected, actual)
    }

    @Test
    fun caesarCipher() {
        val str = "xyz"
        val n = 1
        val expected = "yza"
        val actual = tests.caesarCipher(str, n)
        assertEquals(expected, actual)
    }

    @Test
    fun doesCharAppearMoreThanOnce() {
        val str = "aabc"
        val expected = true
        val actual = tests.doesCharAppearMoreThanOnce(str)
        assertEquals(expected, actual)
    }

    @Test
    fun returnSmallestNElements() {
        val elements = listOf(3, 2, 64, 4, 5)
        val n = 3
        val expected = listOf(4, 2, 3)
        val actual = tests.returnSmallestNElements(elements, n)
        assertEquals(expected.sorted(), actual.sorted())
    }
    //endregion

    //region ADVANCED LEVEL
    @Test
    fun testPush() {
        val addFunction = stack.add()
        addFunction(1)
        addFunction(2)
        stack.add(3)
        assertEquals(3, stack.peek())
        stack.remove()
        assertEquals(2, stack.peek())
        assertEquals(2, stack.size)
    }

    @Test
    fun weave() {
        val stack1 = myTests.Stack<Int>()
        stack1.add(1)
        stack1.add(2)
        stack1.add(3)

        val stack2 = myTests.Stack<Int>()
        stack2.add(4)
        stack2.add(5)
        stack2.add(6)

        val newStack = tests.weave(stack1, stack2)
        assertEquals(4, newStack.remove())
        assertEquals(1, newStack.remove())
        assertEquals(5, newStack.remove())
        assertEquals(2, newStack.remove())
        assertEquals(6, newStack.remove())
        assertEquals(3, newStack.remove())
        assertNull(newStack.remove())
    }

    @Test
    fun digitFrequency() {
        var str1 = "123"
        var str2 = "321"
        assertTrue(tests.digitFrequency(str1, str2))
        str1 = "4557"
        str2 = "745"
        assertFalse(tests.digitFrequency(str1, str2))
    }

    @Test
    fun getDuplicatedArguments() {
        val list = listOf("a", "b", "c", "a", "b", "d")
        val expected = listOf("a", "b")
        val actual = tests.getDuplicatedArguments(list)
        assertEquals(expected, actual)
    }

    @Test
    fun listHasTwoElementsWhichAverageIsEqualToTarget() {
        val list = listOf(3, 5, 9, 7, 11, 14)
        val target = 8.0
        println(tests.elementsWhichAverageIsEqualToTarget(list, target))
        assertTrue(tests.listHasTwoElementsWhichAverageIsEqualToTarget(list, target))
    }


    //endregion

    @Test
    fun anyCallbak() {
        val list = listOf(1, 2, 3)
        val callback:((Int) -> Boolean) = { it > 3 }
        assertFalse(tests.anyCallbak(list, callback))
    }

    @Test
    fun flatten() {
        val listLists = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6))
        val list = listOf(1, 2, listOf(3, 4, listOf(5, 6)), 7, 8)
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val actual = tests.flatten(list)
        assertEquals(expected, actual)
    }

    @Test
    fun surroundedLetter() {
        val str1 = "+a+"
        assertTrue(tests.surroundedLetter(str1))
        val str2 = "+ab+"
        assertFalse(tests.surroundedLetter(str2))
        val str3 = "+a+b+"
        assertTrue(tests.surroundedLetter(str3))
        val str4 = "+a++b++"
        assertTrue(tests.surroundedLetter(str4))
    }
}













