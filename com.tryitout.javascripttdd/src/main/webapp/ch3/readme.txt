Testing with JsTestDriver:
1. Installation
http://code.google.com/p/js-test-driver/downloads/list
2. Run the server
java -jar JsTestDriver-1.3.5.jar --port 4224

Open browser at http://localhost:4224
The two links allow us to decide if we want to run tests with a transitional or strict doctype

3. Create test config file (jsTestDriver.conf). The configuration file, jsTestDriver.conf by default, uses YAML syntax,
and at its simplest, it loads every source file and every test file, and runs tests at http://localhost:4224

4. Extensions:
Jstdutil is a Ruby project that adds a thin command line
interface to JsTestDriver. It provides a leaner command to run tests as well as an
jsautotest command that runs related tests whenever files in the project change.

Eclipse plugin http://js-test-driver.googlecode.com/svn/update/

Idea plugin http://confluence.jetbrains.net/display/WI/Installation+of+JsTestDriver+IntelliJ+plugin
            http://confluence.jetbrains.net/display/WI/Getting+Started+with+JsTestDriver+IntelliJ+plugin
            create strftime_test.jstd - Idea JsTestDriver conf script


The full list of supported assertions in JsTestDriver is:
            • assert(msg, value)
            • assertTrue(msg, value)
            • assertFalse(msg, value)
            • assertEquals(msg, expected, actual)
            • assertNotEquals(msg, expected, actual)
            • assertSame(msg, expected, actual)
            • assertNotSame(msg, expected, actual)
            • assertNull(msg, value)
            • assertNotNull(msg, value)
            • assertUndefined(msg, value)
            • assertNotUndefined(msg, value)
            • assertNaN(msg, number)
            • assertNotNaN(msg, number)
            • assertException(msg, callback, type)
            • assertNoException(msg, callback)
            • assertArray(msg, arrayLike)
            • assertTypeOf(msg, type, object)
            • assertBoolean(msg, value)
            • assertFunction(msg, value)
            • assertNumber(msg, value)
            • assertObject(msg, value)
            • assertString(msg, value)
            • assertMatch(msg, pattern, string)
            • assertNoMatch(msg, pattern, string)
            • assertTagName(msg, tagName, element)
            • assertClassName(msg, className, element)
            • assertElementId(msg, id, element)
            • assertInstanceOf(msg, constructor, object)
            • assertNotInstanceOf(msg, constructor, object)