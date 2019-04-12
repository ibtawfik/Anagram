package solution

object Anagram {

  def isAnagramSubstring(s1: String, s2: String): Boolean = {
    if (s1.length < s2.length || (!s1.isEmpty && s2.isEmpty)) {
      false
    } else {
      val s2Hash: Long = s2.map(CharToPrime(_)).product
      var windowHash: Long = s1.substring(0, s2.length).map(CharToPrime(_)).product
      if (s2Hash == windowHash) return true

      val charArray = s1.toCharArray
      var leftIndex = 0
      var rightIndex = lastIndex(s2)

      while (rightIndex < lastIndex(s1)) {
        windowHash = windowHash / CharToPrime(charArray(leftIndex)) * CharToPrime(charArray(rightIndex + 1))
        leftIndex = leftIndex + 1
        rightIndex = rightIndex + 1
        if (s2Hash == windowHash) return true
      }
      false
    }
  }

  private def lastIndex(s: String) = s.length - 1
}


