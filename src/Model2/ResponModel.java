package Model2;

public class ResponModel {
        public String Message ;
        public String Status ;
        public String Comment ;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }


    public static void main(String[] args) {
        ResponModel Respon = new ResponModel();
        Respon.setMessage("data received");
        Respon.setStatus("halo siswa algo");
        Respon.setComment("anda sudah terkoneksi ke server mimoapps");

}
    {
    }
}

