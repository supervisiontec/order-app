package sv.com.orderapp.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.model.MDepartment;
import sv.com.orderapp.model.MItem;
import sv.com.orderapp.model.MMainCategory;
import sv.com.orderapp.model.MRoute;
import sv.com.orderapp.model.MSubCategory;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.model.MUser;

/**
 * Created by Mohan on 5/26/2016.
 */
public class SyncUtility {
    public static final String SERVER_URL = "http://192.168.1.2:8080/OrderApp/app/rest-api";

    private Context context;
    private DatabaseHelper databaseHelper;

    public SyncUtility(Context context) {
        this.context = context;
        this.databaseHelper = databaseHelper;
    }

    private static <T> T readFromServer(String urlString, Class<T> c) throws IOException {
        URL url = new URL(urlString);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String jsonStr = response.toString();

        Gson gson = new Gson();

        return gson.fromJson(jsonStr, c);
    }

    public void syncAll() throws IOException {
        syncDepartments();

        syncMainCategories();

        syncSubCategories();

        syncItems();

        syncRoutes();

        syncClients();

        syncUsers();
    }

    public void syncDepartments() throws IOException {
        MDepartment[] array = readFromServer("/list-department", MDepartment[].class);

        for (MDepartment object : array) {
            databaseHelper.saveDepartment(object);
        }
    }

    public void syncMainCategories() throws IOException {
        MMainCategory[] array = readFromServer("/list-main-category", MMainCategory[].class);

        for (MMainCategory object : array) {
            databaseHelper.saveMainCategory(object);
        }
    }


    public void syncSubCategories() throws IOException {
        MSubCategory[] array = readFromServer("/list-sub-category", MSubCategory[].class);

        for (MSubCategory object : array) {
            databaseHelper.saveSubCategory(object);
        }
    }


    public void syncItems() throws IOException {
        MItem[] array = readFromServer("/list-item", MItem[].class);

        for (MItem object : array) {
            databaseHelper.saveItem(object);
        }
    }


    public void syncRoutes() throws IOException {
        MRoute[] array = readFromServer("/list-route", MRoute[].class);

        for (MRoute object : array) {
            databaseHelper.saveRoute(object);
        }
    }

    public void syncClients() throws IOException {
        MTransactor[] array = readFromServer("/list-client", MTransactor[].class);

        for (MTransactor object : array) {
            databaseHelper.saveTransactor(object);
        }
    }


    public void syncUsers() throws IOException {
        MUser[] array = readFromServer("/list-user", MUser[].class);

        for (MUser object : array) {
            databaseHelper.saveUser(object);
        }
    }
}
