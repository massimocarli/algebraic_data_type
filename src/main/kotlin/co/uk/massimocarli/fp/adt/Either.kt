package co.uk.massimocarli.fp.adt

/**
 * We have also seen the Either<A, B> type you can define like this:
 */
sealed class Either<out A, out B>
class Left<A>(val left: A) : Either<A, Nothing>()
class Right<B>(val right: B) : Either<Nothing, B>()

/**
 * We can repeat the same exercise. How many elements we can have with a
 * type like Either<Boolean, Boolean>? We have
 */
val either1 = Left(true)
val either2 = Left(false)
val either3 = Right(true)
val either4 = Right(false)

// We have 4 values which are 2+2 but it could be 2*2. What about the
// type Either<Boolean, Triage>

val eitherTriage1: Either<Boolean, Triage> = Left(true)
val eitherTriage2: Either<Boolean, Triage> = Left(false)
val eitherTriage3: Either<Boolean, Triage> = Right(Triage.RED)
val eitherTriage4: Either<Boolean, Triage> = Right(Triage.YELLOW)
val eitherTriage5: Either<Boolean, Triage> = Right(Triage.GREEN)

// In this case we have Boolean + Triage = 2 + 3 = 5 different values
// We can say the Either is equivalent to the addition of two types.
// What about Unit and Nothing?

val boolNothing1: Either<Boolean, Nothing> = Left(true)
val boolNothing2: Either<Boolean, Nothing> = Left(false)
// val boolNothingN: Either<Boolean, Nothing> = Right(???)

// We cannot create values with Right because we don't have a value of
// type Nothing. We can say that
// Either<Boolean, Nothing> = Boolean + Nothing = 2 + 0 = 2
// Nothing is equivalent to 0

// What about Unit?
val boolUnit1: Either<Boolean, Unit> = Left(true)
val boolUnit2: Either<Boolean, Unit> = Left(false)
val boolUnit3: Either<Boolean, Unit> = Right(Unit)
// We have Either<Boolean, Unit> = Boolean + Unit = 2 + 1 = 3
// Unit is equivalent to 1






