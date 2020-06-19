package co.uk.massimocarli.fp.adt

// Suppose you want to implement a callback logic where the callback
// is like the following
typealias Callback<Data, Result, Error> = (Data, Result?, Error?) -> Unit

// You always have Data
// IN case of success you might have a Result
// You might also have an Error

// In the previous Callback<Result, Data, Error> is not type safe because
// you might have values which make no sense. Suppose you have this method which
// accepts a callback like the following.

class Response
class Info
class ErrorInfo

fun runSync(callback: Callback<Response, Info, ErrorInfo>) {
    // You might invoke the callback with different values. This is
    // not valid because you have a response but neither Info or
    // the error
    callback(Response(), null, null)
    // At the same time you might have both Info and ErrorInfo because
    // the previous callback type allows this.
    callback(Response(), Info(), ErrorInfo())
}

// How can we create something more type safe? We can use algebra
// The possible options are
// (Response and Info)   or
// (Response and ErrorInfo)
// This means
// Response * Info + Response * ErrorInfo =>
// Response * (Info + ErrorInfo) =>
// Pair<Response, Either<Info, ErrorInfo>>

// Now the possible value of the Pair<Response, Either<Info, ErrorInfo>> type
// are exactly what we need and what we can have as a callback. Our callback
// then becomes

typealias SafeCallback<Data, Result, Error> = (Pair<Data, Either<Result, Error>>) -> Unit








