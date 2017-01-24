// Source : https://leetcode.com/problems/reverse-string/
// Author : Austin Vern Songer
// Date   : 2016-04-26

/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
  if (s === null)
    return s;

  return s.split('').reverse().join('');
};