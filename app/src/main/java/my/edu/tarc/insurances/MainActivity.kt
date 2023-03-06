package my.edu.tarc.insurances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import my.edu.tarc.insurances.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val age = binding.spinnerAge.selectedItemPosition
        val gender = binding.radioGroupGender.checkedRadioButtonId
        val smoker = binding.checkBoxSmoker.isChecked

        binding.buttonCalculate.setOnClickListener{
            var basic: Int = 0
            var extra: Int = 0
            var total=0
            if (gender == binding.radioButtonMale.id){
                if(age == 0){ //Less than 17
                    basic = 60
                }
                else if(age == 1){ //Less than 17
                    basic = 70
                    extra = 50
                    if (smoker){
                        extra += 100
                    }
                }
                else if(age == 2){ //Less than 17
                    basic = 90
                    extra = 100
                    if (smoker){
                        extra += 150
                    }
                }
                else if(age == 3){ //Less than 17
                    basic = 120
                    extra = 150
                    if (smoker){
                        extra += 200
                    }
                }
                else if(age == 4){ //Less than 17
                    basic = 150
                    extra = 200
                    if (smoker){
                        extra += 250
                    }
                }
                else{
                    basic = 150
                    extra = 200
                    if (smoker){
                        extra += 300
                    }
                }
            }
            else{
                if(age == 0){ //Less than 17
                    basic = 60
                    if (smoker){
                        extra += 0
                    }
                }
                else if(age == 1){ //Less than 17
                    basic = 70
                    if (smoker){
                        extra += 100
                    }
                }
                else if(age == 2){ //Less than 17
                    basic = 90
                    if (smoker){
                        extra += 150
                    }
                }
                else if(age == 3){ //Less than 17
                    basic = 120
                    if (smoker){
                        extra += 200
                    }
                }
                else if(age == 4){ //Less than 17
                    basic = 150
                    if (smoker) {
                        extra += 250
                    }
                }
                else{
                    basic = 150
                    if (smoker){
                        extra += 300
                    }
                }
            }


            total = basic + extra
            binding.myPremium = Premium(basic,extra,total)
        }

        binding.buttonReset.setOnClickListener{
            binding.myPremium = Premium()
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            binding.spinnerAge.setSelection(0)

        }
    }
}