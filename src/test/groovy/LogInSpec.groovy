import com.github.javafaker.Faker
import com.github.javafaker.Internet
import dataProviders.UserDataProvider
import dataProviders.ValidationMessages
import geb.spock.GebReportingSpec
import jodd.util.RandomString
import pages.MainPage
import pages.loginAndCreatingAccount.FacebookLoginPage
import pages.loginAndCreatingAccount.LoginViewPage
import spock.lang.Shared
import spock.lang.Unroll

class LogInSpec extends GebReportingSpec {
    @Shared
    Internet faker = new Faker().internet()
    @Shared
    ValidationMessages msg = new ValidationMessages()
    @Shared
    def user = new UserDataProvider().correctUser
    @Shared
    RandomString random = new RandomString()

    def setup() {
        to MainPage
        toLoginView()
        at LoginViewPage
    }

    @Unroll
    def 'Should not be possible to log on with email: #email and password: #password because: #validationMessage #secondValidationMessage'() {
        when:
        fillFormAndClickLogInButton(email, password)

        then:
        at LoginViewPage
        validationMessage in userZoneModule.form.errorMessage.collect { it -> it.text() }
        if (secondValidationMessage != '') {
            secondValidationMessage in userZoneModule.form.errorMessage.collect { it -> it.text() }
        }

        where:
        email                                                 || password         || validationMessage          || secondValidationMessage
        faker.emailAddress()                                  || faker.password() || msg.invalidEmailOrPassword || ''
        faker.emailAddress()                                  || ''               || msg.emptyPassword          || ''
        ''                                                    || faker.password() || msg.emptyEmail             || ''
        ''                                                    || ''               || msg.emptyPassword          || msg.emptyEmail
        random.randomAlpha(1)                                 || faker.password() || msg.invalidEmailAddress    || ''
        random.randomAlpha(24)                                || faker.password() || msg.invalidEmailAddress    || ''
        random.randomAlpha(10) + '@'                          || faker.password() || msg.invalidEmailAddress    || ''
        "@${random.randomAlpha(5)}"                           || faker.password() || msg.invalidEmailAddress    || ''
        "@${random.randomAlpha(5)}.${random.randomAlpha(5)}"  || faker.password() || msg.invalidEmailAddress    || ''
        random.randomAlpha(10) + "@${random.randomAlpha(5)}"  || faker.password() || msg.invalidEmailAddress    || ''
        random.randomAlpha(10) + "@${random.randomAlpha(5)}." || faker.password() || msg.invalidEmailAddress    || ''
    }

    def 'Should logged on'() {
        when:
        fillFormAndLogIn(user.email, user.password)

        then:
        at MainPage
    }

    def 'Should logged on via facebook button'() {
        given:
        def winHandleBefore = driver.getWindowHandle()

        when:
        loginViaFacebookButton()

        and:
        for (winHandle in driver.getWindowHandles()) {
            driver.switchTo().window(winHandle)
        }

        then:
        at FacebookLoginPage

        when:
        fillFormAndLogIn(user.email, user.password)

        and:
        driver.switchTo().window(winHandleBefore)

        then:
        at MainPage
    }
}
