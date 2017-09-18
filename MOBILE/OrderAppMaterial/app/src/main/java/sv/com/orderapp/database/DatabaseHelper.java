package sv.com.orderapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.model.MDepartment;
import sv.com.orderapp.model.MItem;
import sv.com.orderapp.model.MMainCategory;
import sv.com.orderapp.model.MRoute;
import sv.com.orderapp.model.MSubCategory;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.model.MUser;
import sv.com.orderapp.model.TOrderDetail;
import sv.com.orderapp.model.TOrderSummary;
import sv.com.orderapp.util.FormatUtil;

/**
 * Created by Mohan on 5/26/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "order_app";
    private static final int DATABASE_VERSION = 1;

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.context = context;

//        onUpgrade(getReadableDatabase(), 1, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.database);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        StringBuilder builder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String rawSql = builder.toString();

            String[] sqls = rawSql.split(";");
            for (String sql : sqls) {
                db.execSQL(sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS `m_transactor`");
        db.execSQL("DROP TABLE IF EXISTS `m_route`");
        db.execSQL("DROP TABLE IF EXISTS `m_item`");
        db.execSQL("DROP TABLE IF EXISTS `m_department`");
        db.execSQL("DROP TABLE IF EXISTS `m_main_category`");
        db.execSQL("DROP TABLE IF EXISTS `m_sub_category`");
        db.execSQL("DROP TABLE IF EXISTS `t_order_summary`");
        db.execSQL("DROP TABLE IF EXISTS `t_order_detail`");
        db.execSQL("DROP TABLE IF EXISTS `m_user`");

        onCreate(db);
    }

    //transactor
    public List<MTransactor> getTransactorList(int route) {
        String sql = "SELECT * FROM `m_transactor` WHERE `route` = ? AND client = 1";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, new String[]{String.valueOf(route)});
        cursor.moveToFirst();

        List<MTransactor> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MTransactor object = new MTransactor();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setServerId(cursor.getInt(cursor.getColumnIndex("server_id")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setContactPerson(cursor.getString(cursor.getColumnIndex("contact_person")));
            object.setAddressLine1(cursor.getString(cursor.getColumnIndex("address_line1")));
            object.setAddressLine2(cursor.getString(cursor.getColumnIndex("address_line2")));
            object.setAddressLine3(cursor.getString(cursor.getColumnIndex("address_line3")));
            object.setMobile(cursor.getString(cursor.getColumnIndex("mobile")));
            object.setTelephone1(cursor.getString(cursor.getColumnIndex("telephone1")));
            object.setTelephone2(cursor.getString(cursor.getColumnIndex("telephone2")));
            object.setFax(cursor.getString(cursor.getColumnIndex("fax")));
            object.setRoute((cursor.getInt(cursor.getColumnIndex("route"))));
            object.setCreditAmount(cursor.getDouble(cursor.getColumnIndex("credit_amount")));
            object.setCreditLimit(cursor.getDouble(cursor.getColumnIndex("credit_limit")));
            object.setClient(cursor.getInt(cursor.getColumnIndex("client")) == 1);
            object.setSupplier(cursor.getInt(cursor.getColumnIndex("supplier")) == 1);
            object.setLastVisitedDate(FormatUtil.parseDate(cursor.getString(cursor.getColumnIndex("last_visited_date"))));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MTransactor getTransactor(int indexNo) {
        String sql = "SELECT * FROM `m_transactor` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MTransactor object = null;
        if (cursor.getCount() == 1) {
            object = new MTransactor();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setServerId(cursor.getInt(cursor.getColumnIndex("server_id")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setContactPerson(cursor.getString(cursor.getColumnIndex("contact_person")));
            object.setAddressLine1(cursor.getString(cursor.getColumnIndex("address_line1")));
            object.setAddressLine2(cursor.getString(cursor.getColumnIndex("address_line2")));
            object.setAddressLine3(cursor.getString(cursor.getColumnIndex("address_line3")));
            object.setMobile(cursor.getString(cursor.getColumnIndex("mobile")));
            object.setTelephone1(cursor.getString(cursor.getColumnIndex("telephone1")));
            object.setTelephone2(cursor.getString(cursor.getColumnIndex("telephone2")));
            object.setFax(cursor.getString(cursor.getColumnIndex("fax")));
            object.setRoute((cursor.getInt(cursor.getColumnIndex("route"))));
            object.setCreditAmount(cursor.getDouble(cursor.getColumnIndex("credit_amount")));
            object.setCreditLimit(cursor.getDouble(cursor.getColumnIndex("credit_limit")));
            object.setClient(cursor.getInt(cursor.getColumnIndex("client")) == 1);
            object.setSupplier(cursor.getInt(cursor.getColumnIndex("supplier")) == 1);
            object.setLastVisitedDate(FormatUtil.parseDate(cursor.getString(cursor.getColumnIndex("last_visited_date"))));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        Log.d("SELECT", indexNo + "-" + object);

        cursor.close();
        return object;
    }

    public void saveTransactor(MTransactor object) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("`server_id`", object.getServerId());
        contentValues.put("`name`", object.getName());
        contentValues.put("`contact_person`", object.getContactPerson());
        contentValues.put("`address_line1`", object.getAddressLine1());
        contentValues.put("`address_line2`", object.getAddressLine2());
        contentValues.put("`address_line3`", object.getAddressLine3());
        contentValues.put("`mobile`", object.getMobile());
        contentValues.put("`telephone1`", object.getTelephone1());
        contentValues.put("`telephone2`", object.getTelephone2());
        contentValues.put("`fax`", object.getFax());
        contentValues.put("`route`", object.getRoute());
        contentValues.put("`credit_amount`", object.getCreditAmount());
        contentValues.put("`credit_limit`", object.getCreditLimit());
        contentValues.put("`client`", object.isClient() ? 1 : 0);
        contentValues.put("`supplier`", object.isSupplier() ? 1 : 0);
        contentValues.put("`last_visited_date`", FormatUtil.formatDate(object.getLastVisitedDate()));
        contentValues.put("`version`", object.getVersion());

        if (getTransactor(object.getIndexNo()) == null) {
            db.insert("`m_transactor`", null, contentValues);
            Log.d("INSERT", "INSERT");
        } else {
            db.update("`m_transactor`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
            Log.d("UPDATE", "UPDATE");
        }
    }

    //route
    public List<MRoute> getRoute() {
        String sql = "SELECT * FROM `m_route`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<MRoute> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MRoute object = new MRoute();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MRoute getRoute(int indexNo) {
        String sql = "SELECT * FROM `m_route` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MRoute object = null;
        if (cursor.getCount() == 1) {
            object = new MRoute();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        cursor.close();
        return object;
    }

    public void saveRoute(MRoute object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("`index_no`", object.getIndexNo());
        contentValues.put("`name`", object.getName());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`m_route`", null, contentValues);
        } else {
            db.update("`m_route`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }

    //item
    public List<MItem> getItemList() {
        String sql = "SELECT * FROM `m_item`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<MItem> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MItem object = new MItem();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setCode(cursor.getString(cursor.getColumnIndex("code")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setPrintDescription(cursor.getString(cursor.getColumnIndex("print_description")));
            object.setDepartment(getDepartment(cursor.getInt(cursor.getColumnIndex("department"))));
            object.setMainCategory(getMainCategory(cursor.getInt(cursor.getColumnIndex("main_category"))));
            object.setSubCategory(getSubCategory(cursor.getInt(cursor.getColumnIndex("sub_category"))));
            object.setCostPrice(cursor.getDouble(cursor.getColumnIndex("cost_price")));
            object.setRetailPrice(cursor.getDouble(cursor.getColumnIndex("retail_price")));
            object.setMaxDiscountPercent(cursor.getDouble(cursor.getColumnIndex("max_discount_percent")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MItem getItem(int indexNo) {
        String sql = "SELECT * FROM `m_item` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MItem object = null;
        if (cursor.getCount() == 1) {
            object = new MItem();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setCode(cursor.getString(cursor.getColumnIndex("code")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setPrintDescription(cursor.getString(cursor.getColumnIndex("print_description")));
            object.setDepartment(getDepartment(cursor.getInt(cursor.getColumnIndex("department"))));
            object.setMainCategory(getMainCategory(cursor.getInt(cursor.getColumnIndex("main_category"))));
            object.setSubCategory(getSubCategory(cursor.getInt(cursor.getColumnIndex("sub_category"))));
            object.setCostPrice(cursor.getDouble(cursor.getColumnIndex("cost_price")));
            object.setRetailPrice(cursor.getDouble(cursor.getColumnIndex("retail_price")));
            object.setMaxDiscountPercent(cursor.getDouble(cursor.getColumnIndex("max_discount_percent")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        cursor.close();
        return object;
    }

    public void saveItem(MItem transactor) {

    }

    //department
    public List<MDepartment> getDepartmentList() {
        String sql = "SELECT * FROM `m_department`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<MDepartment> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MDepartment object = new MDepartment();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MDepartment getDepartment(int indexNo) {
        String sql = "SELECT * FROM `m_department` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MDepartment object = null;
        if (cursor.getCount() == 1) {
            object = new MDepartment();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        cursor.close();
        return object;
    }

    public void saveDepartment(MDepartment object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("`index_no`", object.getIndexNo());
        contentValues.put("`name`", object.getName());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`m_department`", null, contentValues);
        } else {
            db.update("`m_department`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }

    //main category
    public List<MMainCategory> getMainCategoryList() {
        String sql = "SELECT * FROM `m_main_category`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        List<MMainCategory> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MMainCategory object = new MMainCategory();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MMainCategory getMainCategory(int indexNo) {
        String sql = "SELECT * FROM `m_main_category` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MMainCategory object = null;
        if (cursor.getCount() == 1) {
            object = new MMainCategory();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        cursor.close();
        return object;
    }

    public void saveMainCategory(MMainCategory object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("`index_no`", object.getIndexNo());
        contentValues.put("`name`", object.getName());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`m_main_category`", null, contentValues);
        } else {
            db.update("`m_main_category`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }

    //sub category
    public List<MSubCategory> getSubCategoryList() {
        String sql = "SELECT * FROM `m_sub_category`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<MSubCategory> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MSubCategory object = new MSubCategory();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MSubCategory getSubCategory(int indexNo) {
        String sql = "SELECT * FROM `m_sub_category` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MSubCategory object = null;
        if (cursor.getCount() == 1) {
            object = new MSubCategory();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        cursor.close();
        return object;
    }

    public void saveSubCategory(MSubCategory object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("`index_no`", object.getIndexNo());
        contentValues.put("`name`", object.getName());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`m_sub_category`", null, contentValues);
        } else {
            db.update("`m_sub_category`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }

    //order summary
    public List<TOrderSummary> getOrderSummaryList() {
        String sql = "SELECT * FROM `t_order_summary`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<TOrderSummary> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            TOrderSummary object = new TOrderSummary();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setServerId(cursor.getInt(cursor.getColumnIndex("server_id")));
            object.setOrderDate(FormatUtil.parseDate(cursor.getString(cursor.getColumnIndex("order_date"))));
            object.setClient((cursor.getInt(cursor.getColumnIndex("client"))));
            object.setTotalItemValue(cursor.getDouble(cursor.getColumnIndex("total_item_value")));
            object.setItemDiscountValue(cursor.getDouble(cursor.getColumnIndex("item_discount_value")));
            object.setSpecialDiscountPercent(cursor.getDouble(cursor.getColumnIndex("special_discount_percent")));
            object.setSpecialDiscountValue(cursor.getDouble(cursor.getColumnIndex("special_discount_value")));
            object.setNetValue(cursor.getDouble(cursor.getColumnIndex("net_value")));
            object.setPaymentMethod(cursor.getString(cursor.getColumnIndex("payment_method")));
            object.setOrderByUser((cursor.getInt(cursor.getColumnIndex("order_by_user"))));
            object.setApprovedByUser((cursor.getInt(cursor.getColumnIndex("approved_by_user"))));
            object.setApprovedDate(FormatUtil.parseDate(cursor.getString(cursor.getColumnIndex("approved_date"))));
            object.setStatus(cursor.getString(cursor.getColumnIndex("status")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public TOrderSummary getOrderSummary(int indexNo) {
        String sql = "SELECT * FROM `t_order_summary` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        TOrderSummary object = null;
        if (cursor.getCount() == 1) {
            object = new TOrderSummary();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setServerId(cursor.getInt(cursor.getColumnIndex("server_id")));
            object.setOrderDate(FormatUtil.parseDate(cursor.getString(cursor.getColumnIndex("order_date"))));
            object.setClient((cursor.getInt(cursor.getColumnIndex("client"))));
            object.setTotalItemValue(cursor.getDouble(cursor.getColumnIndex("total_item_value")));
            object.setItemDiscountValue(cursor.getDouble(cursor.getColumnIndex("item_discount_value")));
            object.setSpecialDiscountPercent(cursor.getDouble(cursor.getColumnIndex("special_discount_percent")));
            object.setSpecialDiscountValue(cursor.getDouble(cursor.getColumnIndex("special_discount_value")));
            object.setNetValue(cursor.getDouble(cursor.getColumnIndex("net_value")));
            object.setPaymentMethod(cursor.getString(cursor.getColumnIndex("payment_method")));
            object.setOrderByUser((cursor.getInt(cursor.getColumnIndex("order_by_user"))));
            object.setApprovedByUser((cursor.getInt(cursor.getColumnIndex("approved_by_user"))));
            object.setApprovedDate(FormatUtil.parseDate(cursor.getString(cursor.getColumnIndex("approved_date"))));
            object.setStatus(cursor.getString(cursor.getColumnIndex("status")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));
        }

        cursor.close();
        return object;
    }

    public void saveOrderSummary(TOrderSummary object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("`server_id`", object.getServerId());
        contentValues.put("`order_date`", FormatUtil.formatDate(object.getOrderDate()));
        contentValues.put("`client`", object.getClient());
        contentValues.put("`total_item_value`", object.getTotalItemValue());
        contentValues.put("`item_discount_value`", object.getItemDiscountValue());
        contentValues.put("`special_discount_percent`", object.getSpecialDiscountPercent());
        contentValues.put("`special_discount_value`", object.getSpecialDiscountValue());
        contentValues.put("`net_value`", object.getNetValue());
        contentValues.put("`payment_method`", object.getPaymentMethod());
        contentValues.put("`order_by_user`", object.getOrderByUser());
        contentValues.put("`approved_by_user`", object.getApprovedByUser());
        contentValues.put("`approved_date`", FormatUtil.formatDate(object.getApprovedDate()));
        contentValues.put("`status`", object.getStatus());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`t_order_summary`", null, contentValues);
        } else {
            db.update("`t_order_summary`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }

    //order detail
    public List<TOrderDetail> getOrderDetailList() {
        String sql = "SELECT * FROM `t_order_detail`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<TOrderDetail> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            TOrderDetail object = new TOrderDetail();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setServerId(cursor.getInt(cursor.getColumnIndex("server_id")));
            object.setOrderSummary(cursor.getInt(cursor.getColumnIndex("order_summary")));
            object.setItem(getItem(cursor.getInt(cursor.getColumnIndex("item"))));
            object.setCostPrice(cursor.getDouble(cursor.getColumnIndex("cost_price")));
            object.setRetailPrice(cursor.getDouble(cursor.getColumnIndex("retail_price")));
            object.setMaxDiscountPercent(cursor.getDouble(cursor.getColumnIndex("max_discount_percent")));
            object.setQuantity(cursor.getDouble(cursor.getColumnIndex("quantity")));
            object.setDiscountPercent(cursor.getDouble(cursor.getColumnIndex("discount_percent")));
            object.setItemValue(cursor.getDouble(cursor.getColumnIndex("item_value")));
            object.setDiscountPercent(cursor.getDouble(cursor.getColumnIndex("discount_value")));
            object.setNetValue(cursor.getDouble(cursor.getColumnIndex("net_value")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public TOrderDetail getOrderDetail(int indexNo) {
        String sql = "SELECT * FROM `t_order_detail` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        TOrderDetail object = null;
        if (cursor.getCount() == 1) {
            object = new TOrderDetail();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setServerId(cursor.getInt(cursor.getColumnIndex("server_id")));
            object.setOrderSummary(cursor.getInt(cursor.getColumnIndex("order_summary")));
            object.setItem(getItem(cursor.getInt(cursor.getColumnIndex("item"))));
            object.setCostPrice(cursor.getDouble(cursor.getColumnIndex("cost_price")));
            object.setRetailPrice(cursor.getDouble(cursor.getColumnIndex("retail_price")));
            object.setMaxDiscountPercent(cursor.getDouble(cursor.getColumnIndex("max_discount_percent")));
            object.setQuantity(cursor.getDouble(cursor.getColumnIndex("quantity")));
            object.setDiscountPercent(cursor.getDouble(cursor.getColumnIndex("discount_percent")));
            object.setItemValue(cursor.getDouble(cursor.getColumnIndex("item_value")));
            object.setDiscountPercent(cursor.getDouble(cursor.getColumnIndex("discount_value")));
            object.setNetValue(cursor.getDouble(cursor.getColumnIndex("net_value")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

        }

        cursor.close();
        return object;
    }

    public void saveOrderDetail(TOrderDetail object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("`server_id`", object.getServerId());
        contentValues.put("`order_summary`", object.getOrderSummary());
        contentValues.put("`item`", object.getItem().getIndexNo());
        contentValues.put("`cost_price`", object.getCostPrice());
        contentValues.put("`retail_price`", object.getRetailPrice());
        contentValues.put("`max_discount_percent`", object.getMaxDiscountPercent());
        contentValues.put("`quantity`", object.getQuantity());
        contentValues.put("`discount_percent`", object.getDiscountPercent());
        contentValues.put("`item_value`", object.getItemValue());
        contentValues.put("`discount_value`", object.getDiscountPercent());
        contentValues.put("`net_value`", object.getNetValue());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`t_order_detail`", null, contentValues);
        } else {
            db.update("`t_order_detail`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }

    //user
    public List<MUser> getUserList() {
        String sql = "SELECT * FROM `m_user`";

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        List<MUser> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            MUser object = new MUser();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setUserName(cursor.getString(cursor.getColumnIndex("username")));
            object.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

            //
            list.add(object);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public MUser getUser(int indexNo) {
        String sql = "SELECT * FROM `m_user` where `index_no` = ?";

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(indexNo)});
        cursor.moveToFirst();

        MUser object = null;
        if (cursor.getCount() == 1) {
            object = new MUser();

            //set values
            object.setIndexNo(cursor.getInt(cursor.getColumnIndex("index_no")));
            object.setName(cursor.getString(cursor.getColumnIndex("name")));
            object.setUserName(cursor.getString(cursor.getColumnIndex("username")));
            object.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            object.setVersion(cursor.getInt(cursor.getColumnIndex("version")));

        }

        cursor.close();
        return object;
    }

    public void saveUser(MUser object) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("`index_no`", object.getIndexNo());
        contentValues.put("`name`", object.getName());
        contentValues.put("`username`", object.getUserName());
        contentValues.put("`password`", object.getPassword());
        contentValues.put("`version`", object.getVersion());

        if (getRoute(object.getIndexNo()) == null) {
            db.insert("`t_order_summary`", null, contentValues);
        } else {
            db.update("`t_order_summary`", contentValues, "`index_no` = ?", new String[]{String.valueOf(object.getIndexNo())});
        }
    }
}
