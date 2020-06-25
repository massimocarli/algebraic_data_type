package co.uk.massimocarli.fp.adt

// Suppose we want to represent the Int type in a different way.
// Suppose we just use not negative integer
// A possible way is the following
sealed class NaturalNumber
object Zero : NaturalNumber()
class Successor(prec: NaturalNumber) : NaturalNumber()

// This allows us to write the following
val ZERO = Zero
val ONE = Successor(Zero)
val TWO = Successor(Successor(Zero)) // Successor(ONE)
val THREE = Successor(Successor(Successor(Zero))) // Successor(TWO)
// And so on

// What is interesting is that, comparing the previous definition with
// the Either one, this can be written as
// NaturalNumber = 1 + NaturalNumber
// This is because the Either nature is translated into an addition
// But the previous addition becomes
//
// NaturalNumber = 1 + NaturalNumber
// NaturalNumber = 1 + (1 + NaturalNumber)
// NaturalNumber = 1 + (1 + (1 + NaturalNumber))
// NaturalNumber = 1 + (1 + (1 + (1 + NaturalNumber)))
// And so on

// This suggests us that the Set of the NaturalNumber can be seen as a
// sequence of 1s, one for each natural number.

// Let's consider then a List<A>. Using the same thought you can think of it
// as something of the following type
sealed class FList<out A>
object FEmpty : FList<Nothing>()
class Tail<A>(val head: A, val tail: FList<A>) : FList<A>()

// This means that a FList (Functional List) can be empty or can be
// thought as an head and a tail which might be empty or not
// You can then create a list of 3 values in the following way

val countList = Tail(1, Tail(2, Tail(3, Tail(4, Tail(5, FEmpty)))))

// What if you want to calculate the sum of the elements into the FList?
// You can implement a recursive function like this
fun FList<Int>.sum(): Int = when (this) {
    is FEmpty -> 0
    is Tail<Int> -> head + tail.sum()
}
// You can test it with the following main()
fun main() {
    println(countList.sum())
}

// But from an agebraic point of view how can we write the previous
// FList<A> type? You can write the following
//
// FList(A) = 1 + A * FList(A)
//
// This is because it can be the FEmpty (and so the 1)
// Or a Pair of an object of type A and another FList<A>
// YOu can repeat what done in the case of the NaturalNumber and get
// FList(A) = 1 + A * FList(A)
//          = 1 + A * (1 + A * FList(A)) = 1 + A + A^2 + A * FList(A)
//          = 1 + A + A^2 + A^3 + A^4 * FList(A)
// This allows us to see the FList(A) as a possible combination of all
// the possible FList(A) of length 0, 1, 2, 3 and so on
// The + means logical OR so a FList(A) is
// OR an empty FList
// OR one element of type A
// OR a pair of element of type A
// OR a triple of element of type A
// and so on.


// But you can do better writing
// FList(A) = 1 + A * FList(A)    =>
// FList(A) - A * FList(A) = 1    =>
//
// FList(A) * (1 - A) = 1         =>
//
//               1
// FList(A) =  -------
//             (1 - A)
//
// This is the geometric series which is equivalent to
// 1 + A + A^2 + A^3 + A^4 + .... + A^N + ...
// Which is what we wrote before





