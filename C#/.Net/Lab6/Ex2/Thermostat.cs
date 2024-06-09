using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex2
{
    public class Thermostat
    {
        public delegate void TemperatureChangeHandler(
            float newTemperature
        );
        private float _CurrentTemperature;
        // Xác định nhà xuất bản sự kiện
        private TemperatureChangeHandler _OnTemperatureChange;
        public TemperatureChangeHandler OnTemperatureChange
        {
            get { return _OnTemperatureChange;}
            set { _OnTemperatureChange = value;}
        }
        public float CurrentTemperature
        {
            get { return _CurrentTemperature; }
            set{
                if (value != CurrentTemperature){
                    _CurrentTemperature = value;
                    // call subscribers
                    if (OnTemperatureChange != null){}{
                        OnTemperatureChange(value);
                    }
                }
            }
        }
    }
}