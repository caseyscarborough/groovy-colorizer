package com.caseyscarborough.colorizer

import org.junit.Test
import org.junit.Before
import static org.junit.Assert.assertEquals

class ColorizerTest {

  def nonColorStrings = [
    "[what]foo",
    "[not_a_color]bar",
    "[foo]bar",
    "[bar]foo"
  ]

  def colorStrings = [
    "[blue]foo [red]bar": "\033[34mfoo \033[31mbar\033[0m",
    "[_black][yellow]bar [cyan]foo [_white]foo": "\033[40m\033[33mbar \033[36mfoo \033[107mfoo\033[0m",
    "[foo][lightRed]bar": "[foo]\033[91mbar\033[0m"
  ]

  // These are used to test the mixins, and should match the ones in Colorizer
  def colorCodes = [
    default:        39,
    black:          30,
    red:            31,
    green:          32,
    yellow:         33,
    blue:           34,
    magenta:        35,
    cyan:           36,
    lightGray:      37,
    darkGray:       90,
    lightRed:       91,
    lightGreen:     92,
    lightYellow:    93,
    lightBlue:      94,
    lightMagenta:   95,
    lightCyan:      96,
    white:          97,
    _default:       49,
    _black:         40,
    _red:           41,
    _green:         42,
    _yellow:        43,
    _blue:          44,
    _magenta:       45,
    _cyan:          46,
    _lightGray:     47,
    _darkGray:     100,
    _lightRed:     101,
    _lightGreen:   102,
    _lightYellow:  103,
    _lightBlue:    104,
    _lightMagenta: 105,
    _lightCyan:    106,
    _white:        107
  ]

  @Before
  void setUp() {
    Colorizer.initializeMixins()
  }

  @Test
  void testNonColors() {
    nonColorStrings.each { string ->
      assertEquals Colorizer.colorize(string), string
    }
  }

  @Test
  void testColors() {
    colorStrings.each { input, output ->
      assertEquals Colorizer.colorize(input), output
    }
  }

  @Test
  void testMixins() {
    colorCodes.each { color, code ->
      assertEquals "foo"."$color"(), "\033[${code}mfoo\033[0m"
    }
  }
}