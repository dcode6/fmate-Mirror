import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.navigateToUrl(GlobalVariable.bsaeURL)

WebUI.waitForAngularLoad(0)

WebUI.verifyElementPresent(findTestObject('homePage_OR/img_desk_logo ng-scope (1)'), 0)

username = CustomKeywords.'essentials.dateTimeData.generateUsername'()

email = CustomKeywords.'essentials.dateTimeData.generateEmail'(username)

WebUI.setText(findTestObject('homePage_OR/input_email (1)'), email)

WebUI.setText(findTestObject('homePage_OR/input_pwd (1)'), password)

boolEmailRequired = WebUI.verifyElementNotVisible(findTestObject('homePage_OR/span_Email is required. (1)'))

boolEmailInvalied = WebUI.verifyElementNotVisible(findTestObject('homePage_OR/span_Invalid email address.'))

boolPassRequired = WebUI.verifyElementNotVisible(findTestObject('homePage_OR/span_Password is required. (1)'))

boolPassLenError = WebUI.verifyElementNotVisible(findTestObject('homePage_OR/span_Password must be minimum'))

WebUI.click(findTestObject('homePage_OR/button_Join  Get 15.00 (1)'))

boolEmailAlreadyPresent = WebUI.verifyElementNotVisible(findTestObject('homePage_OR/div_That email or username is'), FailureHandling.OPTIONAL)

WebUI.waitForPageLoad(0)

WebUI.verifyElementPresent(findTestObject('followBrand_OR/h1_Follow Your Favorite Brands'), 0)

WebUI.click(findTestObject('followBrand_OR/button_Continue to My Feed'))

WebUI.waitForPageLoad(10)

WebUI.verifyElementVisible(findTestObject('followBrand_OR/a_MY FEED'), FailureHandling.CONTINUE_ON_FAILURE)

