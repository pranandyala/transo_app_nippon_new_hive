package com.ezyloads.transo.nippon.shipper.utils

import java.math.RoundingMode
import java.text.DecimalFormat

class CalculationUtils {
    companion object {
        public fun getTon(length: String, width: String, height: String): String? {
            try {
                var value = length.toFloat() * width.toFloat() * height.toFloat()
                value /= 5000
                value /= 1000
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                return df.format(value).toDouble().toString()
            } catch (e: Exception) {
                return "0"
            }
        }

        public fun getCubicMetre(length: String, width: String, height: String): String? {
            try {
                var value = length.toFloat() * width.toFloat() * height.toFloat()
                value /= 5000
                value /= 1000
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                return df.format(value).toDouble().toString()
//                return value.roundToInt().toString()
            } catch (e: Exception) {
                return "0"
            }
        }


        public fun getLitres(length: String, width: String, breadth: String): String? {

            return length
        }

    }
}