import axios from 'axios';
import {useEffect, useState } from "react";
import Swal from 'sweetalert2';


function Customer() {

    const [customerid, setId] = useState('');
  const [customername, setName] = useState("");
  const [address, setAddress] = useState("");
  const [nicnumber, setNicnumber] = useState("");
  const [contactnumber, setContactNumber] = useState("");
  const [customer, setUsers] = useState([]);


 //load the data using useEffect
//  useEffect(() => {
//   (async () => await Load())();
//   }, []);
 
 
  async function  Load()
  {
     const result = await axios.get(
         "http://localhost:8080/api/v1/customer/getAll");
         setUsers(result.data);
         console.log(result.data);
  }
 

  
     async function save(event)
    {
        event.preventDefault();
    try
        {
         await axios.post("http://localhost:8080/api/v1/customer/save",
        {
            patientname: customername,
            address: address,
            nicnumber: nicnumber,
            contactnumber: contactnumber
        });
          alert("customer Registation Successfully");
          setId("");
          setName("");
          setAddress("");
          setNicnumber("");
          setContactNumber("");
          Load();
        }
    catch(err)
        {
          alert("Customer Registation Failed");
        }
   }

 
   async function editcustomer(customer)
   {
    setName(customer.customername);
    setAddress(customer.address);
    setNicnumber(customer.nicnumber);
    setContactNumber(customer.contactnumber); 
    setId(customer._id);
   }
 
   async function DeletePatient(customerid)
   {
        await axios.delete("http://localhost:8080/api/v1/customer/delete/" + customerid); 
        alert("Customer deleted Successfully");
        Load();
   }
 
   async function update(event)
   {
    event.preventDefault();
 
   try
       {
        await axios.put("http://localhost:8080/api/v1/customer/edit/" + customerid ,
       {

        patientname: customername,
        address: address,
        nicnumber: nicnumber,
        contactnumber: contactnumber
       
       });
         alert("Registation Updated");
         setId("");
         setName("");
         setAddress("");
         setNicnumber("");
         setContactNumber("");
         Load();
       }
   catch(err)
       {
         alert("Customer Updateddd Failed");
       }
  }


  const Toast = Swal.mixin({
    toast: true,
    position: "top-end",
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    didOpen: (toast) => {
      toast.onmouseenter = Swal.stopTimer;
      toast.onmouseleave = Swal.resumeTimer;
    }
  });

  const handleSubmit = async (event) => {
    event.preventDefault();

    const payload = {
      name: event.target.name.value,
      nic: event.target.nic.value,
      address: event.target.address.value,
      contact: event.target.contact.value,
      email: event.target.email.value,
      doctor: event.target.doctor.value,
    }

    if(payload.doctor !== ""){
      axios.post('/customer/save', payload)
      .then(data => {
        Toast.fire({
          icon: "success",
          title: "Signed in successfully"
        });
        document.getElementById("Customer-form").reset()
      })
      .catch(err => {
        
        Toast.fire({
          icon: "error",
          title: "Unexpected error occured"
        });
        
      })
    }else{
      alert("Please select a Vehical")
    }

  }


    return (

      <>
        <div className='row'>
          <div className='col-7 offset-3'>
            <div className="card pb-3 pt-3 mt-5" style={{ backgroundColor: 'lightblue', padding: '20px' }}>
              <div className="card-title">
                <h3 className='text-center mt-2'>Customer Registration</h3 >
              </div>
              <div className='card-body'>
                <form id='customer-form' onSubmit={handleSubmit}>
                  <label><b>Customer Name :</b></label>
                  <input name='name' className='form-control'/><br />
                  <label><b>NIC No :</b></label>
                  <input name='nic' className='form-control'/><br />
                  <label><b>Customer Address :</b></label>
                  <input name='address' className='form-control'/><br />
                  <label><b>Contact Number :</b></label>
                  <input name='contact' className='form-control'/><br />
                  <label><b>Customer Email :</b></label>
                  <input name='email' className='form-control'/><br />
                  <label><b>Select Vehical : </b></label>
                  <select name='Vehical' className='form-control'>
                    <option value="" selected>-- Select a Vehicals --</option>
                    <option>VagenR</option>
                    <option>CHR</option> 
                    <option>Maruti</option>
                    <option>Skutiy</option>
                    <option>Van</option>
                    <option>Fulsure</option>
                    <option>KDH</option>
                  </select><br />
                  <button type='submit' className='btn btn-primary mt-3 form-control'>Submit</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </>

//       <div style={{ backgroundColor: 'lightblue', padding: '20px' }}>
//         <h1 align="center">Customer Details</h1>
//         <div class="container mt-4">
//             <form>
//                 <div class="form-group">
//                     <label>Customer Name:</label>
//                     <input type="text" class="form-control" id="customertname" 
//                     value={customername}
//                     onChange={(event) =>
//                     {
//                         setName(event.target.value);
//                     }}
                    
//                     />
//                 </div>

//                 <div class="form-group">
//                     <label>Address:</label>
//                     <input type="text" class="form-control" id="address"
//                     value={address}
//                     onChange={(event) =>
//                     {
//                         setAddress(event.target.value);
//                     }} 
//                     />
//                 </div>
//                 <div class="form-group">
//                     <label>NIC No:</label>
//                     <input type="text" class="form-control" id="nicnumber"
//                     value={nicnumber}
//                     onChange={(event) =>
//                     {
//                       setNicnumber(event.target.value);
//                     }} 
//                     />
//                 </div>

//                 <div class="form-group">
//                     <label>
//                         Contact Number:
//                     </label>
//                     <input type="text" class="form-control" id="contactnumber"
//                     value={contactnumber}
//                     onChange={(event) =>
//                     {
//                         setContactNumber(event.target.value);
//                     }} />
//                 </div>

//                 <div>
//                     <button class="btn btn-primary mt-4"  onClick={save}>Register</button>
//                     <button class="btn btn-warning mt-4"  onClick={update}>Update</button>
//                 </div>
//             </form>
//         </div>

//         <br/>
// <table class="table table-dark" align="center">
//   <thead>
//     <tr>
//       <th scope="col">customer Name</th>
//       <th scope="col">Address</th>
//       <th scope="col">NIC No</th>
//       <th scope="col">Contact Number</th>
      
//       <th scope="col">Option</th>
//     </tr>
//   </thead>
//        {patients.map(function fn(customer)
//        {
//             return(
//             <tbody>
//                 <tr>
//                 <td>{patient.customername}</td>
//                 <td>{patient.address}</td>
//                 <td>{patient.nicnumber}</td>
//                 <td>{patient.contactnumber}</td>        
//                 <td>
//                     <button type="button" class="btn btn-warning"  onClick={() => editCustomer(customer)} >Edit</button>  
//                     <button type="button" class="btn btn-danger" onClick={() => DeleteCustomer(customer._id)}>Delete</button>
//                 </td>
//                 </tr>
//             </tbody>
//             );
//             })}
//             </table>
            
//       </div>
    );
  }
  
  export default Customer;