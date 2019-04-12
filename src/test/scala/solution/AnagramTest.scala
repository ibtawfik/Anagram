package solution

import org.scalatest.FunSuite
import Anagram._

class AnagramTest extends FunSuite{
  test("An ordered substring at the start of a long string that is an anagram should return true"){
     assert(isAnagramSubstring("abbacdfress", "abb"))
  }

  test("An ordered substring in the middle of a long string that is an anagram should return true"){
    assert(isAnagramSubstring("abbacdfress", "cdf"))
  }

  test("An ordered substring in the end of a long string that is an anagram should return true"){
    assert(isAnagramSubstring("abbacdfress", "ress"))
  }

  test("A substring that doesn't represent an anagram should return false"){
    assert(!isAnagramSubstring("abcdefg", "fa"))
  }

  test("An unordered substring match"){
    assert(isAnagramSubstring("abbacdfress", "cad"))
  }

  test("S2 > S1 should return false"){
    assert(!isAnagramSubstring("cad", "abbacdfress"))
  }

  test("If S2 is empty and S1 is not then a match should not be found"){
    assert(!isAnagramSubstring("cad", ""))
  }

  test("If both S1 and S2 are empty assume it's a match"){
    assert(isAnagramSubstring("", ""))
  }

  test("Anagrams with repeating unordered chars should be found"){
    assert(isAnagramSubstring("abcabcabc","bacc"))
  }
}
