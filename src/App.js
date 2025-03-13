import { useContext, useEffect, useState } from "react";
import parient from "./components/Customer";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import axios from "axios";
import Login from "./components/Login";
// Bootstrap CSS
import "bootstrap/dist/css/bootstrap.min.css";
// Bootstrap Bundle JS
import "bootstrap/dist/js/bootstrap.bundle.min";
import PaymentForm from "./components/PaymentForm";
import BookingForm from "./components/BookingForm";
import UpdateCustomerDetails from "./components/UpdateCustomerDetails";
import UserRegistrationForm from "./components/UserRegistrationForm";
import { UserRoles } from "./constants/UserRoles";
import { AuthContext } from "./contexts/AuthContext";
import TestReportDetails from "./components/TestReportDetails";
import NavBar from "./components/NavBar";


function App() {


  const [userData, setUserData] = useState({id: null, name: null, mobile: null, email: null, role: null});
const [isLogin, setIsLogin] = useState(false);

const getNavs = (role) => {
  switch(role){
    case UserRoles.VEHICALOWNERS:
      return [
          {
            name: 'Booking',
            link: '/'
          },
          {
            name: 'User Registration',
            link: '/user-registration-form'
          }
      ]

      case UserRoles.TECHNICIAN:
        return [
          {
            name: 'Upload Reports',
            link: '/'
          }
        ]

        default:
          return [
            {
              name: 'Customer Registration',
              link: '/Customer'
            },
            {
              name: 'Payment',
              link: '/payment'
            },
            {
              name: 'Check Reports',
              link: '/check-reports'
            },
          ]
  }
}

  axios.defaults.baseURL = 'http://localhost:8080/api/v1';

  const getRoutes = (role) => {
    switch (role) {
      case UserRoles.DOCTOR:
        return (
          <>
            <Route path="/" Component={BookingForm}/>
            <Route path="/updateCustomerDetails" Component={UpdateCustomerDetails}/>
            <Route path="/user-registration-form" Component={UserRegistrationForm}/>
          </>
        )

        

      default:
        return (
          <>
            <Route path="/" Component={Login}/>
            <Route path="/Customer" Component={Customer}/>
            <Route path="/payment" Component={PaymentForm}/>
            <Route path="/check-reports" Component={TestReportDetails}/>
          </>
        )
    }
  }
  

  return (
    <div>
      <AuthContext.Provider value={{isLogin, userData, setUserData, setIsLogin}}>
      <NavBar navLinks={getNavs(userData.role)} isLoginProp={isLogin}/>
      <Routes>
      {getRoutes(userData?.role)}
      </Routes>
      </AuthContext.Provider>
    </div>
  );
}

export default App;
