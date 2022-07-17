You are given an array of strings `words`. Each element of `words` consists of two lower English letters.

Create the longest possible palindrome by selecting some elements from `words` and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return `0`.

A palindrome is a string that reads the same forward and backward.



#### Example 1

```
Input: words = ["lc", "cl", "gg"]
Output: 6
```

```
Input: word = ["ab", "ty", "yt", "lc", "cl", "ab"]
Output: 8 (tylcclyt or lctyytcl)
```

```
Input: words = ["cc", "ll", "xx"]
Output: 2
```



#### 1. Questions

* Does any of the strings in the input repeat?
  * It does repeat
* $1 \leq words.length \leq 10^5$
* $words[i].length == 2$
* $words[i]$ consists of lowercase English letters



#### 2. An Example



#### 3. An Initial Solution

* HashSet of int `hitList` to record index of used strings
* boolean `identical` to record the existence of orphan strings that has repeated characters
* int `counter` to record number of pairs of repeated strings
* for each string
  * if in `hitList`, continue
  * for all strings behind it
    * check if they mirror each other
      * yes: `counter++`
      * add both of them to `hitList`
      * break
  * outside for loop?
  * check if its characters are identical
    * yes: `identical = true`

```pseudocode
FUNCTION longestPalindrome(String[] words) RETURN int:
	SET HashSet<Integer> hitList = new HashSet<Integer>
	SET bool identical = false
	SET int counter = 0
	
	main:
	FOR int i = 0 : words.length - 1
		IF hitList.contains(i)
			CONTINUE
		END IF
		
		SET char1 = words[i].charAt(0)
		SET char2 = words[i].charAt(1)
		
		FOR int j = i + 1 : words.length - 1
			IF hitList.contains(j)
				CONTINUE
			END IF
			
			IF char1 == words[j].charAt(1) && char2 == words[j].charAt(0)
				counter++
				hitList.add(i)
				hitList.add(j)
				continue main;
			END IF
		END FOR
		
		IF char1 == char2
			identical == true
		END IF
	END FOR
	
	RETURN counter * 4 + (identical ? 2 : 0)
```



#### 4. Test The Solution

* This method timed out in LeetCode
  * The search takes $O(n^2)$
  * We can group some of the searches together
    * Store them in a hash map

```pseudocode
FUNCTION longestPalindrome(String[] words) RETURN int:
	SET HashMap<String, Integer> hitCounter = new HashMap
	SET HashSet<String> checked = new HashSet
	SET int totalCount = 0
	SET bool identical = false
	
	FOR int i = 0 : words.length - 1
		IF hitCounter.contains(words[i])
			int val = hitCounter.get(words[i])
			hitCounter.put(words[i], val + 1)
		ELSE
			hitCounter.put(words[i], 1)
		END IF
	END FOR
	
	FOR String word : hitCounter.keys()
		IF checked.contains(word)
			CONTINUE
		END IF
		
		checked.add(word)
		
		char char1 = word.charAt(0)
		char char2 = word.charAt(1)
		
		IF char1 == char2
			SET int wordCount = hitCounter.get(word)
            totalCount += wordCount / 2
			
			IF wordCount % 2 == 1
			    identical = true
			END IF
		ELSE
            SET String inverse = word.reverse()
            
            IF hitCounter.contains(inverse)
            	checked.add(inverse)
            	
            	SET int wordCount = hitCounter.get(word)
            	SET int invCount = hitCounter.get(inverse)
            	
            	totalCount += Math.min(wordCount, invCount)
            END IF
        END IF
	END FOR
	
	RETURN totalCount * 4 + (identical ? 2 : 0)
```



#### 5. Iterate Through Your Solution

* Further optimization?
* We already know our character scope: lower case alphabets
  * We can use a `int[26][26]` array as the HashMap
  * We could also do this in one pass
    * Adding to the hash map when no pair was found
    * Subtracting from the hash map when a pair was found




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

