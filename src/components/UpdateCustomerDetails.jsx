import axios from "axios";

const UpdateCustomerDetails = () => {

    const handleSubmit = async (event) => {
        console.log('[event]', event);
        
        axios.post('/updateCustomerDetails', {username: '', password: ''})
        .then(data => {
            // token
        })
        .catch(err => {
            console.log('[error]', err);
        })
    } 

    return (
        <>
        <div class="container">
        
        <row>
            <div className="offset-4 col-4">
                <div className="card p-3" style={{ backgroundColor: 'lightblue', padding: '20px' }}>
                    <h3 className="text-center">Update Customer Details </h3>
                <form onSubmit={handleSubmit}>
                    <label for="pname"><b>customer Name:</b></label>
                    <input className="form-control" type="text" placeholder="" name="pname" required /><br/>

                    <label for="pnic"><b>Customer NIC:</b></label>
                    <input className="form-control" type="text" placeholder="" name="pnic" required /><br />

                    
                    <label for="email"><b>Email:</b></label>
                    <input className="form-control" type="text" placeholder="" name="email" required /><br />

                    <label><b>Select Vehical : </b></label>
                  <select name='Vwgical' className='form-control'>
                  <option>VagenR</option>
                    <option>CHR</option> 
                    <option>Maruti</option>
                    <option>Skutiy</option>
                    <option>Van</option>
                    <option>Fulsure</option>
                    <option>KDH</option>
                  </select><br />

                    <label for="contactnumber"><b>Contact Number:</b></label>
                    <input className="form-control" type="text" placeholder="" name="contactnumber" required /><br />
                           

                    <button class="btn btn-primary mt-4" type="update"><b>Update</b></button>


                
                </form>
                </div>
            </div>
        </row>
        </div>
        
        
        
        </>

    )
}
export default UpdatePatientDetails;