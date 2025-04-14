# CryptoTrackerApp
Application for tracker cryptocurrency developed in native Android

# <img src="https://media2.giphy.com/media/QssGEmpkyEOhBCb7e1/giphy.gif?cid=ecf05e47a0n3gi1bfqntqmob8g9aid1oyj2wr3ds3mg700bl&rid=giphy.gif" width ="25"><b> &nbsp; Tech Stack &nbsp;🛠</b>
![Kotlin](https://img.shields.io/badge/Kotlin%20-%20blue?style=for-the-badge&logo=kotlin&logoColor=white) 
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose%20-%20%23012B41?style=for-the-badge&logo=jetpack%20compose)
![Clean Architecture](https://img.shields.io/badge/Clean%20Architecture%20-%20%23ccce58?style=for-the-badge)
![Solid](https://img.shields.io/badge/SOLID%20-%20%23031526?style=for-the-badge)
![MVI](https://img.shields.io/badge/MVI%20-%20%23f85a5a?style=for-the-badge)
![Ktor](https://img.shields.io/badge/ktor%20-%20%23FB9EEE?style=for-the-badge&logo=ktor&logoColor=%238554FC)
![Koin](https://img.shields.io/badge/Koin%20-%20%23FAB333?style=for-the-badge)
![Corroutines and flow](https://img.shields.io/badge/Corroutines%20%26%20Flow%20-%20%234d2c87?style=for-the-badge&logo=dagger)
![KotlinX Serialization](https://img.shields.io/badge/KotlinX%20Serialization%20-%20%236f6b55?style=for-the-badge)
![Encyrpt/Decrypt](https://img.shields.io/badge/Encrypt%2FDecrypt%20-%20%235d8807?style=for-the-badge&labelColor=%23000000)
![Material 3](https://img.shields.io/badge/Material%203%20-%20%2301649B?style=for-the-badge&labelColor=%23000000)

# <b> Documentation &nbsp;📄</b>
## Possible Failures due to API Usage Limit Key

### Introduction

Our cryptocurrency application relies on data provided by an external API. This API has a monthly limit of uses (queries) that can be reached at certain times, which can lead to failures in the functionality of the application. In this document, we explain how this usage limit can affect the performance of the application and what steps to take to fix it.

### Steps for Obtaining and Encrypting the API Key in the Application

<b><i>1. Get the KEY API</i></b>
* Navigate to the CoinCap page to obtain the API Key and register on the site if you have not already done so.:
  * URL: https://pro.coincap.io/dashboard
* Once registered, log in to your developer dashboard and request an API KEY.
* Save the API Key you get, as you will need it in the next steps.

<b><i>2. Encrypt the API KEY</i></b>
* Once you have the API KEY, go to the following page to encrypt it:
  * URL: https://www.devglan.com/online-tools/aes-encryption-decryption
* On the encryption page, perform the following steps:
  * Paste the API KEY you obtained in the first box (where it says ‘Text to Encrypt’).
  * In the encryption options section, select NoPadding.
  * Make sure the KeySize option is set to 128 Bits.
  * In the Enter secret key field, enter "aesEncryptionKey" (without quotes).
  * Do not change any other settings, everything else should be left as default.
* Click the Encrypt button to encrypt your API Key.
* Once the encryption is complete, you will see the encrypted key in the Encrypted Text box. Save this encrypted key, as you will need it for the next step.

<b><i>3. Modify the Application Code</i></b>
* Access the source code of your application and navigate to the following file:
  * Path: com/mramallo/cryptotrackerapp/core/domain/util/Constants.kt
* Locate the encrypted API KEY inside this file.
* Find the existing encrypted key (if there is already an encrypted API Key).
* Replace the existing encrypted key with the new encrypted key you obtained in the previous step.

<b><i>4. Run the application and try again</i></b>


# <b> Images &nbsp;🏞️ </b>
![Banner](https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Banner%20CryptoCurrency%20App.png "Banner")

## <b> Portrait App </b>

| asdfdsaf | Coin List | Coin Detail | Line Chart Selected | Error |
| :---         |     :---:      |     :---:     |      :---:      |     :---:     |
| LIGTH   | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Coin%20List%20Light.png" width ="200"> | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Coin%20Detail%20Light.png" width ="200"> | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Coin%20Detail%20LineChart%20Selected%20Light.png" width ="200"> | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Error%20Screen%20Light.png" width ="200"> |
| DARK    | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Coin%20List%20Dark.png" width ="200">  | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Coin%20Detail%20Dark.png" width ="200"> | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Coin%20Detail%20LineChart%20Selected%20Dark.png" width ="200"> | <img src="https://github.com/ManuelRamallo/CryptoTrackerApp/blob/main/resources/Portrait/Error%20Screen%20Dark.png" width ="200">




