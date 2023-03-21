import Model2.ResponModel;
import Network.ConnectURI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class tampilansulis extends JFrame {
    private JButton submitButton;
    private JTextField textMessage;
    private JTextField textStatus;
    private JTextField textComment;
    private JButton closeButton;
    private JPanel LidaCihuy;
    private JFrame lida;

    public tampilansulis(){
        lida = new JFrame("TM1_22090134_MaulidhaSulisFiana");
        lida.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lida.setPreferredSize(new Dimension(440,450));
        lida.setResizable(true);
        lida.add(LidaCihuy);
        lida.pack();
        lida.setLocationRelativeTo(null);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== submitButton){
                    try {
                        URL url = new URL("http://harber.mimoapps.xyz/api/getaccess.php");
                        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");

                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine())!=null){
                            response.append(inputLine);
                        }
                        in.close();

                        JSONArray jsonArray = new JSONArray(response.toString());

                        ArrayList<ResponModel>parsedList = new ArrayList<>();
                        for (int i = 0;i<jsonArray.length();i++){
                            ResponModel resModel = new ResponModel();
                               JSONObject myJSONObjeck = jsonArray.getJSONObject(i);
                            resModel.setMessage(myJSONObjeck.getString("message"));
                            resModel.setStatus(myJSONObjeck.getString("status"));
                            resModel.setComment(myJSONObjeck.getString("comment"));
                            parsedList.add(resModel);


                        }
                        for (int index = 0 ; index < parsedList.size();index++){
                            textMessage.setText(parsedList.get(index).getMessage());
                            textStatus.setText(parsedList.get(index).getStatus());
                            textComment.setText(parsedList.get(index).getComment());
                        }
                    } catch (ProtocolException ex) {
                        throw new RuntimeException(ex);
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectURI koneksi= new ConnectURI();
                URL myAddress = koneksi.buildURL("http://harber.mimoapps.xyz/api/getaccess.php");
                String response = null;
                response = koneksi.getResponseFromHttpUrl(myAddress);
                System.out.println("");
                System.out.println(response);
                System.out.println("");
                System.out.println("");
                System.out.println("* terimakasih *");
                System.exit(0);
            }
        });
        lida.setVisible(true);
    }
    public static void main(String[] args) {
        new tampilansulis();

    }
}
