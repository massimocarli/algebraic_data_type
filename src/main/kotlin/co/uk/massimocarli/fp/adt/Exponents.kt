package co.uk.massimocarli.fp.adt

// So far we've seen addition and multiplication
// What about esponents?
// Given a type A we can have
// A^2 = A * A = Pair<A,A>
// A^3 = A * A * A = Pair<A, Pair<A,A>>
// And so on but given types A and B what does A^B means?
// What does Boolean^Triage means?

// Before we said that
// Boolean => 2
// Triage => 3
// So Boolean^Triage = 2^3 = 8 but 8 what?

// If you think of a function type like (Triage)->Boolean how many
// different values we can have? This is basically a way to represent
// all the possible way we can map a Triage into a Boolean. We can then start
// writing all this possible ways?

fun func0(triage: Triage): Boolean = when (triage) {
    Triage.RED -> false
    Triage.YELLOW -> false
    Triage.GREEN -> false
}

fun func1(triage: Triage): Boolean = when (triage) {
    Triage.RED -> false
    Triage.YELLOW -> false
    Triage.GREEN -> true
}

fun func2(triage: Triage): Boolean = when (triage) {
    Triage.RED -> false
    Triage.YELLOW -> true
    Triage.GREEN -> false
}

fun func3(triage: Triage): Boolean = when (triage) {
    Triage.RED -> false
    Triage.YELLOW -> true
    Triage.GREEN -> true
}

fun func4(triage: Triage): Boolean = when (triage) {
    Triage.RED -> true
    Triage.YELLOW -> false
    Triage.GREEN -> false
}

fun func5(triage: Triage): Boolean = when (triage) {
    Triage.RED -> true
    Triage.YELLOW -> false
    Triage.GREEN -> true
}

fun func6(triage: Triage): Boolean = when (triage) {
    Triage.RED -> true
    Triage.YELLOW -> true
    Triage.GREEN -> false
}

fun func7(triage: Triage): Boolean = when (triage) {
    Triage.RED -> true
    Triage.YELLOW -> true
    Triage.GREEN -> true
}

// There are exactly 8 different way of mapping a Triage into a Boolean
// We can then think of A^B as equivalent to a function from B to A
// and so to (B)->A
// We can use this analogy in order to find some interesting facts

// Given A, B and C we know that:
// (A^B)^C = A^(B * C)
// What does this mean in the case of types. As first step we can
// reverse the equation
//
// A^(B * C) = (A^B)^C
//
// This means that
//
// Pair<B,C> -> A = (C) -> (B) -> A
//
// If you represent Pair<B,C> as (B,C), you get
//
// (B,C) -> A = (C) -> (B) -> A
//
// This is what is called currying. This means that you can rewrite a function
// of two parameters (A,B)->C into a new high order function like this:
//
// (A) -> (B) -> C
//
// Implementing this function is easy:
typealias Func<A, B> = (A) -> B
typealias Func2<A, B, C> = (A, B) -> C
typealias Chain<A, B, C> = (A) -> (B) -> C

fun <A, B, C> Func2<A, B, C>.currying(): (A) -> (B) -> C = { a: A ->
    { b -> this(a, b) }
}

// You can also do the opposite with the uncurrying function
fun <A, B, C> Chain<A, B, C>.uncurrying(): Func2<A, B, C> = { a: A, b: B ->
    this(a)(b)
}

// How currying can be useful? Because of composition
// How can you compose a function with another which accepts
// two parameters? Suppose you have
val square = { a: Int -> a * a }
val add = { a: Int, b: Int -> a + b }

// How can you compose these two functions using the following
// compose function?
infix fun <A, B, C> Func<A, B>.compose(g: Func<B, C>): Func<A, C> = { a: A ->
    g(this(a))
}

// This doesn't work
//val addSquare = square compose add

// But you can use currying with
val addSquare = square compose add.currying()

fun main() {
    println(addSquare(3)(3))
}

// Arhhh, double (). We can do something better because
// A ^ 1 = A which means
// 1->A = A
// Unit -> A = A
// You can define the function
fun <A> to(f: (Unit) -> A): A = f(Unit)

// And also the function which is the inverse
fun <A> from(a: A) = Unit

// With these you can write the previous like




