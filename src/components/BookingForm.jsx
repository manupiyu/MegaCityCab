import axios from "axios";
import Swal from "sweetalert2";

const BookingForm = () => {

    const handleSubmit = (event) => {
        event.preventDefault();

        console.log(event);

        const payload = {
            userId: event.target.userId.value,
            name: event.target.name.value,
            date: event.target.date.value,
            time: event.target.time.value,
        }

        if(payload.date !== "" && payload.time !== "" && payload.name !== "" && payload.userId !== ""){
            axios.post('/booking/create', payload)
            .then(data => {
                
                  Toast.fire({
                    icon: "success",
                    title: "Signed in successfully"
                  });

                  
                document.getElementById("bookingForm").reset();
                // token
            })
            .catch(err => {
                
                Toast.fire({
                    icon: "error",
                    title: "Unexpected error occured"
                  });
            })
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

        
        
        
    } 

    return (
        <>
       <div className="container">
    <div className="row">
        <div className="offset-3 col-6">
            <div className="card p-3" style={{ backgroundColor: 'lightblue', padding: '20px' }}>
                <h3 className="text-center">Booking Form</h3>
                <form id="bookingForm" onSubmit={handleSubmit}>
                    <label htmlFor="cnic"><b>Customer Registration Id:</b></label>
                    <input className="form-control" type="text" name="userId" required /><br/>

                    <label htmlFor="vname"><b>Vehicle Name:</b></label>
                    <input className="form-control" type="text" name="name" required /><br />

                    <label htmlFor="inputDate" className="form-label"><b>Booking Date:</b></label>
                    <input type="date" name="date" className="form-control"/><br />

                    <label htmlFor="timeInput" className="form-label">Booking time:</label>
                    <input type="time" name="time" className="form-control"></input><br />

                    <button className="btn btn-primary mt-4" type="submit"><b>Send Booking</b></button>

                
                </form>
                </div>
            </div>
        </div>
        </div>
        
        
        
        </>

    )
}
export default BookingForm;