package com.cscie88a.week6

import com.cscie88a.testutils.{StandardTest}

// TODO: provide unit test implementations using the SimpleStreams object for the unit tests below

class SimpleStreamsTest extends StandardTest {
  "Streams" when {

    "creating an instance" should {

      "create a finite stream of multiples of 5" in {
        succeed
      }

      "create an infinite stream of random integers between 0 and 15" in {
        succeed
      }

      "create an infinite stream of dogs" in {
        succeed
      }
    }

    "using map, filter, reduce, and reduce operations" should {

      "return a stream of healthy dogs for function healthyDogs" in {
        succeed
      }

      "return the average age of healthy dogs for a sample size for function averageHealthyAge" in {
        succeed
      }
    }

    "using partition and zip operations" should {

      "return two streams of dogs partitioned by health status for function dogsByHealthStatus" in {
        succeed
      }

      "return a stream of pairs of healthy and unhealthy dogs for function pairHealthyUnhealthyDogs" in {
        succeed
      }
    }

    "using data pipelines" should {

      "return a stream of the oldest dog in every 5 samples for function oldestDogs" in {
        succeed
      }
    }

    "using for comprehensions" should {

      "return true only if a triplet of integers (a,b,c) satisfies the equation, a^2 + b^2 = c^2, for function pythTest" in {
        succeed
      }

      "create a stream of pythogorean triplets" in {
        succeed
      }
    }

  }
}
