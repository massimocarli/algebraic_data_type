package co.uk.massimocarli.fp.adt

// Let's use the previous equivalence for some experiment

// Unit is equivalent to 1
// We can then say:
// A * Unit = A = Unit * A
// which means that Pair<A, Unit> is equivalent to Pair<Unit, A> which doesn't
// provide more information than the simple type A

typealias UnitType<A> = Pair<A, Unit>

// Nothing is equivalent to 0
// We can say that
// A + Nothing = Nothing + A = A
// This means that Either<A, Nothing> is equivalent to Either<Nothing, A> which is
// basically A
typealias NothingType<A> = Pair<A, Nothing>

// We can also say that
// A * 0 = 0 * A = 0
// This means that
// Pair<A, Nothing> is equivalent to Pair<Nothing, A> because you cannot
// have any value of both. Nothing kills the type!

// Another curiose thing is that
// A + 1 = A + Unit = Either<A, Unit>
// 1 + A = Unit + A = Either<Unit, A>
// This means that the type Either<A, Unit> is a type which has all the
// possible values of A plus a single value which is Unit. If you think
// about this it's something you could represent like
sealed class Opt<out A>
object None : Opt<Nothing>()
class Some<A>(value: A) : Opt<A>()

// This is basically the Optional type. Or you have a value of type A
// or you have another single and unique value which here is None but that could
// be Unit
