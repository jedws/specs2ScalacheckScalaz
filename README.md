This repo shows a classpath issue between scalacheck 1.10/1.11, specs2 2.3.6 and scalaz-scalacheck-binding 7.0.5  

running `sbt test` should show the following:

    [info] BoxSpec
    [info]   The monadic interpreter should 
    [info]     implement Monad                             
    [info]     monad must satisfy     
    [info]         x monad.applicative.functor.identity
    [error]  Exception raised on argument generation.
    [error]  > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]        
    [info]             x monad.applicative.functor.composite
    [error]      Exception raised on argument generation.
    [error]      > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]      
    [info]         x monad.applicative.identity
    [error]  Exception raised on argument generation.
    [error]  > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]        
    [info]             x monad.applicative.composition
    [error]      Exception raised on argument generation.
    [error]      > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]      
    [info]         x monad.applicative.homomorphism
    [error]  Exception raised on argument generation.
    [error]  > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]        
    [info]             x monad.applicative.interchange
    [error]      Exception raised on argument generation.
    [error]      > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]      
    [info]         x monad.applicative.map consistent with ap
    [error]  Exception raised on argument generation.
    [error]  > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]        
    [info]             x monad.right identity
    [error]      Exception raised on argument generation.
    [error]      > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]      
    [info]         x monad.left identity
    [error]  Exception raised on argument generation.
    [error]  > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]        
    [info]             x monad.associativity
    [error]      Exception raised on argument generation.
    [error]      > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]      
    [info]         x monad.ap consistent with bind
    [error]  Exception raised on argument generation.
    [error]  > Exception: java.lang.NoClassDefFoundError: org/scalacheck/Pretty$ (Prop.scala:639)
    [info]  
    [info]   
    [info] Total for specification BoxSpec
    [info] Finished in 73 ms
    [info] 11 examples, 11 failures, 0 error
    [error] Failed: Total 11, Failed 11, Errors 0, Passed 0
    [error] Failed tests:
    [error]   BoxSpec
    [error] (test:test) sbt.TestsFailedException: Tests unsuccessful
    [error] Total time: 8 s, completed Dec 28, 2013 11:41:19 AM

those appear to indicate that scalacheck 1.10.x's `Prop` is being brought in somehow, yet it should be explicitly excluded. All investigation of the classpath appears to indicate only scalacheck 1.11.1 is present, which makes it difficult to understand the source of these errors.