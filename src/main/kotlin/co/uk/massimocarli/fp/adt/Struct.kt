package co.uk.massimocarli.fp.adt

/**
 * Kotlin provides a specific type which is the Pair type with
 * two different parameters type
 */
typealias Couple<A, B> = Pair<A, B>

/*
Let's try to give some type to A and B and see how many values we can get.
Let's begin with Boolean
 */
typealias BoolPair = Pair<Boolean, Boolean>

val bool1 = Pair(true, true)
val bool2 = Pair(true, false)
val bool3 = Pair(false, true)
val bool4 = Pair(false, false)

// These are the only possible values for the type BoolPair

/**
 * Now let's define the following enum
 */

enum class Triage {
    RED, YELLOW, GREEN
}

val triple1 = Pair(true, Triage.RED)
val triple2 = Pair(true, Triage.YELLOW)
val triple3 = Pair(true, Triage.GREEN)
val triple4 = Pair(false, Triage.RED)
val triple5 = Pair(false, Triage.YELLOW)
val triple6 = Pair(false, Triage.GREEN)

/*
We know 2 nice types in Kotlin. One of these is Unit which is the only value into the
Unit type. You could write:
*/

val unit1 = Pair(Unit, Triage.RED)
val unit2 = Pair(Unit, Triage.YELLOW)
val unit3 = Pair(Unit, Triage.GREEN)

// Another funny type is Nothing.

// val nothing1 : Pair<Nothing, Triage> = Pair(Nothing, Triage.RED) ????

// Make a summary
// Pair<Boolean, Boolean> -> 4
// Pair<Boolean, Triage> -> 6
// Pair<Triage, Unit> -> 3
// Pair<Unit, Unit> -> 1
// Pair<Nothing, Triage> -> 0

// There's a relation between structs and product

// Something happens in the logical world. Logical conjuction
// We have A AND B. AND = together
// We can say Pair<A,B> = A * B

// So far it's simple but wht about
// Pair<Boolean, String> = Boolean * String
// Here we have many values in the String type
// What about Pair<Array<Int>, String> = Array<Int> * String?
// These are infinite set

// Of course we can have other types like
data class Struct(val enabled: Boolean, val triage: Triage, val value: Int)

// This is like 2 * 3 * Int
// Where Int is the dimension of the set of all the Ints


