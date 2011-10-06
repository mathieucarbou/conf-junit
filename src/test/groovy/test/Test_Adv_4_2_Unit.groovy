package test;


import org.junit.experimental.categories.Categories
import org.junit.experimental.categories.Categories.IncludeCategory
import org.junit.runner.RunWith
import org.junit.runners.Suite.SuiteClasses
import org.junit.experimental.categories.Categories.ExcludeCategory

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(Categories)
@SuiteClasses([ATest, Btest, CTest])
@IncludeCategory(UnitTests)
@ExcludeCategory(SystemTests)
class Test_Adv_4_2_Unit {
}
