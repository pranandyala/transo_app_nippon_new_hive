package com.transo.nippon.customer.vendor.nein.user.constants;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constant {

    /*---APP Server---*/
    public static final String APP_IP = "https://app.transo.in";
    /*---UAT Server---*/
    public static final String UAT_IP = "https://uat.transo.in";
    /*---DEV Server---*/
    public static final String DEV_IP = "https://dev.transo.in";
    //    public static final String DEV_IP = "http://192.168.0.125";
    /*---BASE Server---*/
    public static String IP = "";


    //    public static final String PORT = ":5002";
    public static final String API = "/api/";
    //    public static final String API = ":6065/";
    public static final String IP_PY = "https://dev3pl.transo.in/";
    public static final String ANALYTICAL_REPORTS = "/analyticalReports/";
    public static final String URL_DOWNLOAD_URL_BASE = IP + API + "download/file/CommercialTemplate/";
    public static final String URL_DOWNLOAD_URL_THC_BASE = API + "download/file";
    public static final String URL_FTL_COMMERCIAL_BASE = IP + "/commercials/";
    public static final String URL_LTL_COMMERCIAL_BASE = IP + "/commercials/";
    public static final String URL_COMMERCIAL_BASE = "/commercials/";
    public static final String URL_REPORTS_BASE = IP + API + "/analyticalReports/";
    public static final String LTL_BULK_IP = IP + "/commercials/";

    public static final String Eco_Bulk_excel_upload = "/routeOptimization/cvrp";
    public static final String Eco_Temp_download = IP + "/fileDownload/download_file";
    public static final String URL_SUB_CUSTOMER_BASE = IP + "/commercials/";
    public static final String ROUND_TRIP_SUBMIT_BOOKING = "bookingRest/SubmitRoundTypeBooking";

    public static final String AUTO_DL_KYC = "docVerification/dlNumberValidation?dlNumber=";
    private static final String Base = "app/";
    public static final String LOGIN = Base + "login";
    public static final String track = Base + "tripwaypoints";
    public static final String Lr = IP + "/trip/lrcopy/";
    public static final String forgotpassword = Base + "forgotpassword";
    public static final String register = Base + "register";
    public static final String profileupdate = "shipper/profileupdate";
    public static final String changeimage = "shipper/changepic";
    public static final String LTL_BULK_BOOKING = "ltl_bulkbooking";
    public static final String URL_FTL_BULK_BOOKING = "ftl_bulkbooking";


    public static final String invoice = Base + "invoice";
    public static final String status = Base + "status";
    public static final String support = Base + "supportmessage";
    public static final String DASHBOARD_COUNT = Base + "DashboardCounts";
    public static final String GET_NOTIFICATION = "user/getNotifications";
    public static final String DELETE_NOTIFICATION = "user/deleteNotifications";
    public static final String ADD_SHIPPER = "app/submit_shipper";
    public static final String ADD_CUSTOMER = "customer/addCustomer";
    public static final String ADD_VENDOR = "vendor/add";
    public static final String URL_ASSIGN_DRIVER_FOR_SPOT_BOOKING = "bookingRest/driverAssign";

    public static final String URL_ACTIVE_VENDOR_LIST = "vendor/activeVendorList";
    public static final String URL_VEHICLE_LIST_FOR_SPOT_BOOKING = "bookingRest/vehicleListForSpotBooking";
    public static final String URL_VEHICLE_LIST_FOR_AUTO_BOOKING = "bookingRest/vehicleListAutoBooking";
    public static final String URL_DRIVER_LIST_FOR_SPOT_BOOKING = "bookingRest/driverListForSpotBooking";
    public static final String URL_DRIVER_LIST_FOR_VENDOR = "vendor/driverListForVendor";
    public static final String URL_GET_DRIVERlIST_FOR_SPOT_BOOKING = "bookingRest/GetDriverDetailsForSpotBooking";
    public static final String URL_ADD_AUTO_BOOKING_ROUTE = "bookingRest/addAutoBookingRoute";


    public static final String UPDATE_VENDOR = "vendor/update/";

    public static final String CUSTOMER_LIST = "customer/customerList";
    public static final String URL_GPS_VENDORS = "carrier/gpsVenders";

    public static final String BOOKING_CUSTOMER_LIST = "bookingRest/customerList";
    public static final String ADD_SUB_CUSTOMER = "customer/submitBulkSubCustomerDetails";

    public static final String CUSTOMER_LIST_COMMERCIAL = "customer/customerListForCommertial";
    public static final String CUSTOMER_STATUS = "customer/customerStatus";
    public static final String CUSTOMER_ADDRESS_STATUS = "customer/customerAddressStatus";
    public static final String CUSTOMER_UPLOAD = "customer/upload";
    public static final String CUSTOMER_DOWNLOAD = "customer/download";
    public static final String UPDATE_CUSTOMER = "customer/updateCustomer";
    public static final String ADD_CUSTOMER_ADDRESS = "customer/addAddress";
    public static final String ADD_LOCATION = "customer/addLocation";
    public static final String URL_FORGOT_PASSWORD = "user/forgotpassword";

    public static final String UPDATE_CUSTOMER_ADDRESS = "customer/updateCustomerAddress";
    public static final String FTL_PICKUP_ADDRESS_LIST = "bookingRest/ftlPickupAddressList";
    public static final String LTL_PICKUP_ADDRESS_LIST = "bookingRest/ltlPickupAddressList";
    public static final String FTL_DESTINATION_ADDRESS_LIST = "bookingRest/ftlDestinationAddressList";
    public static final String LTL_DESTINATION_ADDRESS_LIST = "bookingRest/ltlDestinationAddressList";
    public static final String LTL_COMMERCIAL_RATE = "bookingRest/ltlCommercialRate";
    public static final String LTL_PENDING_CUSTOMER_LIST = "bookingRest/getPendingLtlBookingCustomerList";
    public static final String LTL_PENDING_WAREHOUSE_LIST = "bookingRest/getPendingLtlBookingWarehouseList";
    public static final String LTL_PENDING_PICKUP_ADDRESS = "bookingRest/getPendingLtlBookingPickupAddress";
    public static final String LTL_GET_ALL_VENDORS = "bookingRest/getAllVendors";

    public static final String LTL_COMPLETE_TRIPS = "trip/LTLCompleteTrip";
    public static final String LTL_INSTANT_BOOKING_REQUEST = "bookingRest/instantLTLBookingRequest";
    public static final String FTL_VEHICLE_TYPE_LIST = "bookingRest/ftlVehicleTypeList";
    public static final String GET_FTL_VEHICLE_TYPE_LIST = "bookingRest/getVehicleTypeList";
    public static final String URL_REQUESTED_LR_FOR_SUPER_ADMIN = "Lr/RequestedLrDetailsForSuperAdmin";
    public static final String URL_LR_FORMAT_DETAILS = "Lr/LrFormatDetailsBranchWise";
    public static final String URL_REQUEST_LR_BY_BRANCH_ADMIN = "Lr/RequestLrNumberByBranchAdmin";
    public static final String URL_LR_NUMBER_SEQUENCE = "Lr/LrListForSubBranch";

    public static final String FTL_CUSTOMER_LIST = "bookingRest/ftlCustomerList";
    public static final String ROUND_TRIP_CUSTOMER_LIST = "bookingRest/RoundTripCustomerList";
    public static final String ROUND_TRIP_PICKUP_ADDRESS_LIST = "bookingRest/RoundTripPickupAddressList";
    public static final String ROUND_TRIP_DESTINATION_ADDRESS_LIST = "bookingRest/RoundTripDestinationAddressList";
    public static final String ROUND_TRIP_VENDOR_LIST = "bookingRest/RoundTripVendorList";
    public static final String ROUND_TRIP_VEHICLE_LIST = "bookingRest/RoundTripVehicleList";
    public static final String ROUND_TRIP_VEHICLE_TYPE_LIST = "bookingRest/RoundTripVehicleTypeList";
    public static final String CONFIRM_LTL_BOOKING = "bookingRest/confirmLTLBooking";
    public static final String LTL_CUSTOMER_LIST = "bookingRest/ltlCustomerList";
    public static final String LTL_EXCEL_DOWNLOAD = "bookingRest/excelDownload";
    public static final String LTL_PENDING_BOOKING_LIST = "bookingRest/ltlPendingBookingList";
    public static final String DELETE_LTL_BOOKING_DROPS = "bookingRest/deleteLtlBookingDrops";
    public static final String DRIVER_DOCUMENTS = "user/documents";
    public static final String UPDATE_DRIVER = "user/updateDriver";
    public static final String GET_DRIVER_LIST = "user/getDriverWithVehicle";
    public static final String ASSIGN_DRIVER = "user/AssignDriver";
    public static final String CHANGE_VEHICLE_STATUS = "user/vehicleStatus";
    public static final String CHANGE_DRIVER_STATUS = "user/driverStatus";
    public static final String UPDATE_DRIVER_DOCUMENTS = "user/updateDriverDocument";
    public static final String ADD_DRIVER = "user/addDriver";
    public static final String DRIVERS_LIST = "user/driverList";
    public static final String VENDOR_DRIVERS_LIST = "user/vendorDriverList";
    public static final String ADD_VEHICLE_DOCUMENTS = "user/addVehicleDocument";
    public static final String REG_NO_VALIDATION = "user/regnoValidation";
    public static final String ADD_VEHICLE = "user/addVehicle";
    public static final String VEHICLE_LIST = "user/vehicleList";
    public static final String VENDOR_VEHICLE_LIST = "user/vendorVehicleList";
    public static final String VEHICLE_DOCUMENTS = "user/vehicledocuments";
    public static final String GET_VEHICLE_DETAILS = "user/getVehicledetails";
    public static final String UPDATE_VEHICLE = "user/updateVehicle";
    public static final String AWAITING_TRIP_CLOSURE = "trip/AwaitingTripClose";
    public static final String TRIP_CLOSURE_REMARKS = "trip/TripClosureRemarks";
    public static final String CLOSE_TRIP = "trip/closeTrip";
    public static final String SHIPMENT_LIST = "trip/shipmentTracking";

    public static final String FTL_VENDOR_LIST = "bookingRest/ftlVendorList";
    public static final String FTL_COMMERCIAL_RATE = "bookingRest/ftlCommercialRate";
    public static final String FTL_COMMERCIAL_VALUE = "bookingRest/checkFtlCommercialValue";

    public static final String LTL_VENDOR_LIST = "bookingRest/ltlVendorList";
    public static final String FTL_VEHICLE_LIST = "bookingRest/ftlVehicleList";
    public static final String URL_FTL_VEHICLE_LIST_WITHOUT_DRIVERAPP = "bookingRest/VehicleListForWithoutDriverApp";
    public static final String URL_FTL_DRIVER_LIST_FOR_VEHICLE = "bookingRest/DriverListForvehicle";

    //    public static final String GET_CUSTOMER_ADDRESS = "customer/getCustomerAddress";
    public static final String BOOKING_CUSTOMER_ADDRESS = "bookingRest/getCustomerAddress";

    public static final String GET_CUSTOMER_ADDRESS_COMMERCIAL = "customer/getCustomerAddressforCommertial";
    public static final String ADD_ADDRESS = "user/addAddress";
    public static final String ADD_SHIPPER_ADDRESS = "app/addAddress";
    public static final String VIEW_SHIPPER_ADDRESS = "app/getAddress";
    public static final String URL_CUSTOMER_ADDRESS = "customer/getCustomerAddress";
    public static final String URL_CONSIGNOR_CONSIGNEE_ADDRESS = "customer/getConsignorConsigneeAddress";

    public static final String ADDRESS_LIST = "user/addressList";
    public static final String UPDATE_ADDRESS = "user/updateAddress";
    public static final String SHIPPER_LIST = "carrier/shipper_list";
    public static final String LR_DETAILS = "3pl/LrBranchCodeDetails";
    public static final String GENERATE_BULK_LR = "3pl/generateBulkLR";

    public static final String LR_NUMBER_LIST = "3pl/LrNumberList";

    public static final String UPDATE_LRNUMBER_STATUS = "3pl/UpdateLrNumberStatus";
    public static final String LR_NUMBER_ACTION = "3pl/lrNumberAction";
    public static final String EXPORT_LR_NUMBER = "3pl/ExportLrNumber";
    public static final String ADD_LR_FORMAT = "3pl/addLrFormat";
    public static final String MATERIAL_TYPE = "bookingRest/BookingMaterialType";
    //    public static final String GET_AVAILABLE_VEHICLE = "bookingRest/availableVehicleListByvehicleType";
    public static final String GET_AVAILABLE_VEHICLE = "bookingRest/SpotAvailableVehicleListByvehicleType";
    public static final String GET_AVAILABLE_OWN_VEHICLE = "bookingRest/OwnFleetAvailableVehicleListByvehicleType";

    public static final String USER_LIST = "user/UserList";
    public static final String GetPodForDrop = "3pl/GetPodForDrop";
    public static final String COMPLETED_TRIPS_VEHICLE_AND_LR_LIST = "trip/completedVehicleNumberAndLrNumberList ";
    public static final String URL_VIOLATIONS = "carrier/violations";
    public static final String URL_DISTRACTED_VIDEOS = "/distractedVideos/new_violations";
    public static final String URL_KM = "carrier/km";
    public static final String URL_FUEL = "carrier/fuel";
    public static final String URL_API_EXPENSE_IMAGE = "carrier/expenseimage";
    public static final String URL_INTRANSIT = "trip/intransit";
    public static final String URL_LIVETRIP_ACCORDIAN = "trip/liveTripAccordion";

    public static final String URL_AT_PICK_UP = "trip/atPickup";
    public static final String URL_AT_DESTINATION = "trip/atDestination";
    public static final String URL_COMPANY_REGISTRATION = "user/companyRegistration";
    public static final String URL_INVOICE_GENERATION = "/invoice_generation";
    public static final String URL_TRIP_KM = "trip/tripKm";
    public static final String URL_TRIP_VIOLATION = "trip/tripViolations";
    public static final String URL_MOVING = "carrier/movingVehicles";
    public static final String URL_IDLE = "carrier/idleVehicles";
    public static final String URL_VIOLATION = "/violations";
    public static final String URL_VEHICLE_NUMBER_VALIDATION = "/docVerification/vehicleNumberValidation?vehicleNumber=";

//    public static final String otp = "rest/otp";

    public static final String otp = "user/otp";

    public static final String profileotp = "rest/profileotp";

    public static final String FILE_UPLOAD_BOOKING = "app/SubmitFileBooking";

    public static final String URL_ADD_CUSTOMER_ZONE = "customer/addCustomerZone";

    public static final String URL_ADD_VENDOR_ZONE = "vendor/addVendorZone";

    public static final String REQUEST_LTL_BULK_BOOKING = "bookingRest/requestLTLBooking";

    public static final String CREATE_VEHICLE = "app/createVehicle";

    public static final String ADD_WAREHOSE = "carrier/addWarehouseByCarrier";

    public static final String CREATE_WAREHOUSE = "user/addWarehouse";

    public static final String ADD_BRANCH = "user/addBranch";

    public static final String GET_ALL_VENDORS = "vendor/getAllVendors";
    public static final String URL_VENDOR_LIST = "vendor/vendorList";

    public static final String GET_OTHER_VENDORS = "vendor/getOtherVendorList";

    public static final String URL_CUSTOMER_GET_ZONE_LIST = "customer/getZoneList";

    public static final String URL_VENDOR_GET_ZONE_LIST = "vendor/getZoneList";

    public static final String URL_GET_STATE_FOR_ZONE_CUSTOMER = "customer/getStateForZone";

    public static final String URL_GET_STATE_FOR_ZONE_VENDOR = "vendor/getStateForZone";

    public static final String WAREHOUSE_LIST = "user/warehouseListForCarrierCompany";

    public static final String GET_WAREHOUSE_LIST = "user/getwarehouseList";

    public static final String SEND_REQUEST = "bookingRest/vendorSMS";

    public static final String BOOK_NOW = "bookingRest/ecorouternearbyvehiclebooking";
    public static final String GET_USER_DETAILS = "UI/getUserDetails";

    public static final String BRANCH_LIST = "user/BranchListForAdmin";

    public static final String URL_BRANCH_LIST_FOR_SPOT_BOOKING = "bookingRest/BranchListForSpotBooking";

    public static final String URL_MANUAL_SHIPMENT_TRACKING = "trip/manualShipmentTracking";

    public static final String URL_FTL_MANUAL_TRACKING = "trip/ftlManualTrackingData";

//    public static final String VEHICLE_lIST_FOR_WAREHOUSE = "app/vehicleListForWarehouse";

    public static final String VEHICLE_lIST_FOR_WAREHOUSE = "carrier/vehicleListForWarehouse";


    public static final String USER_LIST_FOR_BRANCH = "user/userListForBranch";

//    public static final String ASSIGN_WAREHOUSE_FOR_VEHICLE = "app/assignWarehouseForVehicle";

    public static final String ASSIGN_WAREHOUSE_FOR_VEHICLE = "carrier/assignWarehouseForVehicle";


    public static final String ASSIGN_USER_TO_BRANCH = "user/assignBranchToUser";

//    public static final String DISAPLY_COMPANY_DETAILS = "app/edit_company_details";

    public static final String DISAPLY_COMPANY_DETAILS = "carrier/edit_company_details";

    public static final String VEHICLE_STATUS = "app/vehicleStatus";

    public static final String USER_STATUS = "user/userStatus";

    public static final String notification = "shipper/notification";

    public static final String updatepassword = "shipper/updatepassword";

    public static final String TERMS_OF_SERVICE = "user/cms?type=terms_carrier";

    public static final String ABOUT_US = "user/aboutus";

    public static final String PRIVACY_POLICY = "user/cms?type=privacy_policy";

    public static final String HELP_FAQ = "user/help_carrier";

    public static final String GET_AVAILABLE_VEHICLE_TYPES = "bookingRest/getAvailableVehicleTypes";

    public static final String BOOKING_RETRY = "bookingRest/requestRetryBooking";

    public static final String PINCODE_VERIFICATION = Base + "pincodeVerification";

    public static final String SUBMITBOOKING = "bookingRest/SpotSubmitBooking";

    public static final String SUBMITBOOKINGFTL = "bookingRest/submitBooking";


    public static final String LIVE_TRIP = "trip/liveTripDetails";
    public static final String ON_TRIP = "trip/OntripTripDetails";

    public static final String URL_LR_DETAILS_BRANCHWISE = "Lr/LrNumberDetailsBranchWise";

    public static final String URL_LR_DETAILS_SUBBRANCH_WISE = "Lr/LrNumberDetailsSubBranchWise";

    public static final String URL_LR_ALLOCATE = "Lr/LRallocate";

    public static final String URL_SUB_BRANCH_LR_ALLOCATE = "Lr/subBranchLRallocation";

    public static final String COMPLETED_TRIP = "trip/completedTripDetails";

//    public static final String VEHICLE_TYPES_FOR_INDIVIDUAL_BOOKING = "bookingRest/availableVehiclesTypesForIndividualBooking";

    public static final String VEHICLE_TYPES_FOR_INDIVIDUAL_BOOKING = "bookingRest/SpotAvailableVehiclesTypesForIndividualBooking";

    public static final String VEHICLE_TYPES_FOR_OWN_FLEET_BOOKING = "bookingRest/OwnFleetAvailableVehiclesTypes";

    public static final String COMPANY_DETAILS = "carrier/companyinfo";

    public static final String LIVE_TRIP_DETAILS = "shipper/shipmentDetails";

    public static final String PENDING_BOOKING = "bookingRest/pendingAndRetryBooking";

    public static final String URL_API_CANCEL = "shipper/canceltrip";

    public static final String COMPLETED_TRIPS_REMARK = "trip/AddCompletedTripRemark";

    public static final String ADD_VENDOR_LR_NUMBER = "bookingRest/addVendorLrNumber";
    public static final String ADD_ADDITIONAL_CHARGE = "bookingRest/addAdditionalCharge";
    public static final String TRIP_ETA_STATUS = "trip/tripETAStatus";


    public static final String LTL_TRIP_TRACKING = "trip/TrackVendorLrNumberShipment";

    public static final String URL_DISCLAIMER = "user/disclaimer";

//    public static final String TRACK_VEHICLE = "app/trackVehicle";

    public static final String TRACK_VEHICLE = "carrier/trackVehicle";


    public static final String TRIPKM_BY_DIRECTION_API = "trip/TripKmByGoogleDirectionsAPI";

    public static final String SHIPPER_UPDATE = "app/shipper_update";

    public static final String URL_REFRESH_TOKEN = "user/refreshToken";

    public static final String ADD_USER = "user/createSubUser";

    public static final String UPDATE_USER = "user/updateSubUser";

    public static final String UPDATE_BRANCH = "user/updateBranch";

    public static final String UPDATE_WAREHOUSE = "user/updateWarehouse";

    public static final String WARE_HOUSE_DETAILS = Base + "warehouseDetails";

    public static final String LOAD_NEAR_BY_MINI_TRUCKS = Base + "loadNearByMiniTruck";

    public static final String Dashboard = Base + "dashboard";

    public static final String Bookingparameters = Base + "bookingparameters";

    public static final String intransit = Base + "intransit";

    public static final String createbooking = Base + "createbooking";

    public static final String shipmentbydate = Base + "shipmentbydate";

    public static final String shipmentbylocation = Base + "shipmentbylocation";

    public static final int NOTIFY = 7 * 1000;

    public static final String SHIPPER = "app";

    public static final String LRNUMBER_PENDING = "lr_pending";

    public static final String RELAESE_AUTO_LR = "release_auto_lr";

    public static final String LRNUMBER_INPROGRESS = "lr_inprogress";

    public static final String MULTIPLE_VEHICLES = "multiple_vehicles";

    public static final String SUB_SHIPPER = "sub_shipper";

    public static final String VEHICLE_TYPE = "vehicle_type";

    public static final String VEHICLE_NUMBER = "vehicle_number";

    public static final String LR_FORMAT = "lr_format";

    public static final String FILTER_LR_NUMBER_LIST = "filter_lr_number_list";

    public static final String BRANCH = "branch";

    public static int FILE_UPLOAD_SIZE = 200;

    public static String WEIGHT_IN_KG = "weight_in_kg";

    public static String VOLUMETRIC_WEIGHT = "volumetric_weight";

    public static final int PRICE = 20;

    public static final String KEY_VEHICLE_ID = "vehicle_id";

    public static final String LOCATION_WORK = "locationWork";

    public static final String FILE_BOOKING = "fileBooking";
    public static String UPDATED_KM = null;
    public static String BATTERY = null;
    public static int SIGNAL_STRENGTH = 0;
    public static String SIGNAL_STRENGTH_STATUS = null;
    public static final String FORM_BOOKING = "formBooking";
    public static final String SPOT = "spot";
    public static final String OWN_FLEET_SPOT = "OWN FLEET SPOT";

    public static final String KEY_LANGUAGE = "language";
    public static final String FCM_TOKEN = "token";
    public static final String KEY_TYPE = "type";
    public static final String KEY_IP = "baseIp";
    public static final String KEY_APP_VERSION = "appVersion";

    public static final String OWN = "OWN";
    public static final String VENDOR = "VENDOR";


    public static final String GOOGLE_API_KEY_1 = "AIzaSyD";
    public static final String GOOGLE_API_KEY_2 = "Z3Qve64v";
    public static final String GOOGLE_API_KEY_3 = "TNXxdh7wdPY";
    public static final String GOOGLE_API_KEY_4 = "aARb5SfqJ8yEs";


    public static final int NUM_PAGES = 2;

    public static final String GET_VEHICLE_TYPES = "vehicle_type/selectAll";
    public static final String GET_VENDOR_ADDRESS = "customer/getAddressForVendor";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_LIST = "ftl_cust_master/selectAll";
    public static final String URL_FTL_COMMERCIAL_VENDOR_LIST = "ftl_carr_master/selectAll";
    //    public static final String URL_FTL_COMMERCIAL_ADD = "ftl_cust_master/ftladd";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_ADD = "ftl_cust_master/add";
    public static final String URL_FTL_COMMERCIAL_VENDOR_ADD = "ftl_carr_master/add";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_UPDATE = "ftl_cust_master/update/";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_APPROVE = "ftl_cust_master/ftlCustApproval";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_REJECT = "ftl_cust_master/ftlCustReject";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_VIEW = "ftl_cust_master/select/";
    public static final String URL_FTL_COMMERCIAL_VENDOR_UPDATE = "ftl_carr_master/update/";
    public static final String URL_FTL_COMMERCIAL_VENDOR_APPROVE = "ftl_carr_master/ftlVendorApproval";
    public static final String URL_FTL_COMMERCIAL_VENDOR_REJECT = "ftl_carr_master/ftlVendorReject";
    public static final String URL_FTL_COMMERCIAL_VENDOR_VIEW = "ftl_carr_master/select/";
    public static final String URL_FTL_COMMERCIAL_DOWNLOAD_TEMPLATE = "ftl/downloadTemplate/";
    public static final String URL_FTL_COMMERCIAL_UPLOAD = "ftl/upload";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_DOWNLOAD_TEMPLATE = "ftl/downloadTemplateForCustomer/";
    public static final String URL_FTL_COMMERCIAL_VENDOR_DOWNLOAD_TEMPLATE = "ftl/downloadTemplateForVendor/";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_UPLOAD = "ftl/Customerupload";
    public static final String URL_FTL_COMMERCIAL_VENDOR_UPLOAD = "ftl/Carrierupload";
    public static final String URL_FTL_COMMERCIAL_CUSTOMER_LOCATION_LIST = "ftl_cust_master/ftlCustCommercialLocationList";
    public static final String URL_FTL_COMMERCIAL_VENDOR_LOCATION_LIST = "ftl_carr_master/ftlCarrCommercialLocationList";
    public static final String URL_LTL_COMMERCIAL_VENDOR_LOCATION_LIST = "ltl_cust_master/ltlCarrCommercialLocationList";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_LOCATION_LIST = "ltl_cust_master/ltlCustCommercialLocationList";


    //    Download
    public static final String URL_FTL_BULK_BOOKING_DOWNLOAD = "FTL_Booking_template.xlsx";
    public static final String URL_LTL_BULK_BOOKING_DOWNLOAD = "LTLBulkBookingFile.xlsx";

    public static final String URL_FTL_COMMERCIAL_CUSTOMER_DOWNLOAD = "ftl_customer_commercial.xlsx";
    public static final String URL_FTL_COMMERCIAL_VENDOR_DOWNLOAD = "ftl_vendor_commercial.xlsx";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_LOCATION_DOWNLOAD = "ltl_location_commercial_customer.xlsx";
    public static final String URL_LTL_COMMERCIAL_VENDOR_LOCATION_DOWNLOAD = "ltl_location_commercial_vendor.xlsx";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_ZONE_DOWNLOAD = "ltl_zone_commercial_customer.xlsx";
    public static final String URL_LTL_COMMERCIAL_VENDOR_ZONE_DOWNLOAD = "ltl_zone_commercial_vendor.xlsx";
    public static final String URL_CUSTOMER_DOWNLOAD = "CustomerBulk.xlsx";
    public static final String URL_SUB_CUSTOMER_DOWNLOAD = "SubCustomerTemplate.xlsx";


    public static final String URL_FTL_COMMERCIAL_CUSTOMER = URL_DOWNLOAD_URL_BASE + URL_FTL_COMMERCIAL_CUSTOMER_DOWNLOAD;
    public static final String URL_FTL_COMMERCIAL_VENDOR = URL_DOWNLOAD_URL_BASE + URL_FTL_COMMERCIAL_VENDOR_DOWNLOAD;
    public static final String URL_CUSTOMER_TEMPLATE = URL_DOWNLOAD_URL_BASE + URL_CUSTOMER_DOWNLOAD;
    public static final String URL_SUB_CUSTOMER_TEMPLATE = URL_DOWNLOAD_URL_BASE + URL_SUB_CUSTOMER_DOWNLOAD;

    public static final String URL_LTL_COMMERCIAL_CUSTOMER_LOCATION = URL_DOWNLOAD_URL_BASE + URL_LTL_COMMERCIAL_CUSTOMER_LOCATION_DOWNLOAD;
    public static final String URL_LTL_COMMERCIAL_VENDOR_LOCATION = URL_DOWNLOAD_URL_BASE + URL_LTL_COMMERCIAL_VENDOR_LOCATION_DOWNLOAD;
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_ZONE = URL_DOWNLOAD_URL_BASE + URL_LTL_COMMERCIAL_CUSTOMER_ZONE_DOWNLOAD;
    public static final String URL_LTL_COMMERCIAL_VENDOR_ZONE = URL_DOWNLOAD_URL_BASE + URL_LTL_COMMERCIAL_VENDOR_ZONE_DOWNLOAD;

    public static final String URL_FTL_BOOKING_TEMPLATE = URL_DOWNLOAD_URL_BASE + URL_FTL_BULK_BOOKING_DOWNLOAD;
    public static final String URL_LTL_BOOKING_TEMPLATE = URL_DOWNLOAD_URL_BASE + URL_LTL_BULK_BOOKING_DOWNLOAD;

    //   upload


    public static final String URL_FTL_CUSTOMER_COMMERCIAL_UPLOAD = "ftl_customer_commercial";
    public static final String URL_FTL_VENDOR_COMMERCIAL_UPLOAD = "ftl_vendor_commercial";
    public static final String URL_LTL_CUSTOMER_COMMERCIAL_UPLOAD = "ltl_customer_commercial";
    public static final String URL_LTL_VENDOR_COMMERCIAL_UPLOAD = "ltl_vendor_commercial";
    public static final String URL_SUB_CUSTOMER = "sub_customer_bulk_creation";
    public static final String URL_MANUAL_LR_LIST = "Lr/ManualLrListForSubBranch";
    public static final String URL_UPLOAD_POD_BY_USER = "trip/uploadPodByDriver";


    public static final String DOWNLOAD_TEMPLATE = "downloadTemplate";
    public static final String UPLOAD_TEMPLATE = "uploadTemplate";

    //   Reports
    public static final String URL_DSR_REPORTS = "dsr_report";
    public static final String URL_LRWISE_REPORTS = "lr_report";
    public static final String URL_KPI_REPORTS = "kpi_report";
    public static final String URL_POD_REPORTS = "pod_report";
    public static final String URL_P_AND_L_REPORTS = "p_l_report";
    public static final String URL_ANNEXURE_INVOICE_REPORTS = "annexure_report_invoicing";
    public static final String URL_ANNEXURE_VENDOR_REPORTS = "annexure_report_vendor";
    public static final String URL_THC_REPORTS = "thc_report";

    public static final String URL_EDITABLE_ANNEXURE_INVOICING = "editable_annexure_invoice";


    //    public static final String URL_LTL_COMMERCIAL_ADD = "ltl_cust_master/add";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_ADD = "ltl_cust_master/addLTLCustomer";
    public static final String URL_LTL_COMMERCIAL_VENDOR_ADD = "ltl_cust_master/addLTLVendor";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_LIST = "ltl_cust_master/selectAll";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_FROM_ZONE = "ltl_cust_master/ltlCustFromZone";
    public static final String URL_LTL_COMMERCIAL_VENDOR_FROM_ZONE = "ltl_carr_slab/ltlCarrFromZone";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_TO_ZONE = "ltl_cust_master/ltlCustToZone";
    public static final String URL_LTL_COMMERCIAL_VENDOR_TO_ZONE = "ltl_carr_slab/ltlCarrToZone";
    public static final String URL_LTL_COMMERCIAL_VENDOR_LIST = "ltl_carr_slab/selectAll";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_UPDATE = "ltl_cust_master/update/";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_APPROVE = "ltl_cust_master/ltlCustomerApproval";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_REJECT = "ltl_cust_master/ltlCustomerReject";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_VIEW = "ltl_cust_master/select/";
    public static final String URL_LTL_COMMERCIAL_VENDOR_UPDATE = "ltl_carr_slab/update/";
    public static final String URL_LTL_COMMERCIAL_VENDOR_APPROVE = "ltl_carr_slab/ltlVendorApproval";
    public static final String URL_LTL_COMMERCIAL_VENDOR_REJECT = "ltl_carr_slab/ltlVendorReject";
    public static final String URL_LTL_COMMERCIAL_VENDOR_VIEW = "ltl_carr_slab/select/";
    public static final String URL_LTL_COMMERCIAL_DOWNLOAD_TEMPLATE = "ltl/downloadTemplate/";
    public static final String URL_LTL_COMMERCIAL_UPLOAD = "ltl/upload";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_DOWNLOAD_TEMPLATE = "ltl/downloadTemplateforCustomer/";
    public static final String URL_LTL_COMMERCIAL_VENDOR_DOWNLOAD_TEMPLATE = "ltl/downloadTemplateforVendor/";
    public static final String URL_LTL_COMMERCIAL_CUSTOMER_UPLOAD = "ltl/uploadCustLtl";
    public static final String URL_LTL_COMMERCIAL_VENDOR_UPLOAD = "ltl/uploadCarrLtl";
    public static final String URL_LTL_GET_UOM_RANGE = "ltl_cust_master/getUOMRange";
    public static final String URL_LTL_CUSTOMER_CHANGE_STATUS = "ltl_cust_master/LTLCustomerStatus";
    public static final String URL_LTL_CUSTOMER_APPROVE_STATUS = "ltl_cust_master/ApprovedLTLCustomerStatus";
    public static final String URL_LTL_VENDOR_CHANGE_STATUS = "ltl_cust_master/LTLVendorStatus";
    public static final String URL_LTL_VENDOR_APPROVE_STATUS = "ltl_cust_master/ApprovedLTLVendorStatus";


    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_LIST = "roundtrip_cust_master/selectAll";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_LIST = "roundtrip_carr_master/selectAll";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_ADD = "roundtrip_cust_master/addRoundTripCustMaster";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_ADD = "roundtrip_carr_master/addRoundTripCarrMaster";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_UPDATE = "roundtrip_cust_master/update/";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_APPROVE = "roundtrip_cust_master/rtCustApproval";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_REJECT = "roundtrip_cust_master/rtCustReject";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_VIEW = "roundtrip_cust_master/select/";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_UPDATE = "roundtrip_carr_master/update/";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_APPROVE = "roundtrip_carr_master/roundTripVendorApproval";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_REJECT = "roundtrip_carr_master/roundTripVendorReject";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_VIEW = "roundtrip_carr_master/select/";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_DOWNLOAD_TEMPLATE = "roundtrip/downloadTemplateRTCust/";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_DOWNLOAD_TEMPLATE = "roundtrip/downloadTemplateRTCarr/";
    public static final String URL_ROUND_TRIP_COMMERCIAL_CUSTOMER_UPLOAD = "roundtrip/uploadRTCust";
    public static final String URL_ROUND_TRIP_COMMERCIAL_VENDOR_UPLOAD = "roundtrip/uploadRTCarr";

    public static final String URL_THC_GET_TRIP_DETAILS = "thc_masters/getTripdetails";
    public static final String URL_THC_GET_THC_DETAILS = "thc_masters/getTHCdetails";
    public static final String URL_THC_GET_TRIP_ID = "thc_masters/getTripId";
    public static final String URL_THC_ADD_FORMAT = "thc_masters/addTHCFormat";
    public static final String URL_THC_SAVE = "thc_masters/saveTHC";
    public static final String URL_THC_SUBMIT_APPROVAL = "thc_masters/submitForApproval";
    public static final String URL_THC_LIST = "thc_masters/THCList";
    public static final String URL_THC_APPROVAL_BY_HEAD = "thc_masters/ApprovalByHead";
    public static final String URL_THC_REJECTION_BY_HEAD = "thc_masters/RejectionByHead";
    public static final String URL_THC_APPROVAL_BY_FIN_USER = "thc_masters/ApprovalByFinUser";
    public static final String URL_THC_CHEQUE_NO_VALIDATION = "thc_masters/chequeNoValidation";
    public static final String URL_THC_REJECTON_BY_FIN_USER = "thc_masters/RejectionByFinUser";
    public static final String URL_THC_DELETE = "thc_masters/deleteTHC";
    public static final String URL_THC_VIEW = "thc_masters/viewTHC";

    public static final String URL_FTL_GET_COMMERCIAL_CONTRACT_TYPE = "ftl/getCommercialContractType";
    public static final String URL_BRANCH_LIST_FOR_USER = "user/BranchListForUser";
    public static final String URL_GET_WAREHOUSE_LIST = "user/getwarehouseList";
    public static final String URL_FTL_CUSTOMER_RATE = "ftl_cust_master/ftlCustRate";
    public static final String URL_FTL_VENDOR_RATE = "ftl_carr_master/ftlCarrRate";
    public static final String URL_FTL_WAREHOUSE_LIST = "bookingRest/ftlWarehouseList";
    public static final String ALL_WAREHOUSE_LIST = "bookingRest/getwarehouseList";
    public static final String URL_CUSTOMER_STATE_LIST = "customer/getStateList";
    public static final String URL_CUSTOMER_CITY_LIST = "customer/getCityList";
    public static final String URL_CUSTOMER_LOCATION_LIST = "customer/getLocationList";
    public static final String URL_CUSTOMER_ZONE_LIST = "customer/getZoneListForCustomer";
    public static final String URL_VENDOR_ZONE_LIST = "customer/getZoneListForVendor";


    public static final String URL_VEHICLE_PLANNING = "vehicle_planning";
    public static final String URL_VEHICLE_AVAILABILITY = "vehicle_availability";
    public static final String URL_TRIP_ANALYTICS = "trip_analytics";
    public static final String URL_ON_TRIP_CONSIGNOR_DETENTION = "on_trip_consignor_detention";
    public static final String URL_ON_TRIP_CONSIGNEE_DETENTION = "on_trip_consignee_detention";
    public static final String URL_VEHICLE_NEARING_DESTINATION = "vehicle_nearing_destination";
    public static final String URL_SAFETY_VIOLATIONS = "safety_violations";
    public static final String URL_TOP_BOTTOM_TRANSPORTERS = "top_bottom_transporters";


    public static final String KEY_REGISTRATION_DATE = "registration_date";
    public static final String KEY_FUEL_TANK_CAPACITY = "fuel_tank_capacity";
    public static final String KEY_ENGINE_NO = "engine_no";
    public static final String KEY_MANUFACTURE_DATE = "manufacture_date";
    public static final String KEY_CHASSIS_NO = "chassis_no";
    public static final String KEY_MODEL_SUBMODEL = "model_submodel";
    public static final String KEY_VEHICLE_CLASS = "vehicle_class";
    public static final String KEY_VEHICLE_TYPE = "vehicle_type";
    public static final String KEY_MANUFACTURER = "manufacturer";
    public static final String KEY_REG_NO = "regno";
    public static final String KEY_ODOMETER_READING = "odometer_reading";

    public static final String KEY_SHIPPER_ID = "id";
    public static final String KEY_COMPNAY_NAME = "company_name";
    public static final String KEY_PERSON_NAME = "person_name";
    public static final String KEY_MOBILE_NO = "phone_no";
    public static final String KEY_EMAIL_ID = "email_id";
    public static final String KEY_COMPANY_CIN = "company_cin";
    public static final String KEY_COMPANY_PAN = "company_pan";
    public static final String KEY_COMPANY_GST = "company_gst";
    public static final String KEY_COMPANY_ADDRESS = "company_address";

    public static final String KEY_COMPANY_ID = "company_id";
    public static final String KEY_USER_ID = "id";
    public static final String KEY_FIRST_NAME = "firstname";
    public static final String KEY_LAST_NAME = "lastname";
    public static final String KEY_USER_EMAIL_ID = "emailid";
    public static final String KEY_USER_MOBILE_NUMBER = "phone_mobile";
    public static final String KEY_USER_PASSWORD = "password";

    public static final String KEY_ADDRESS = "address";
    public static final String KEY_ID = "id";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_BRANCH_NAME = "branch_name";
    public static final String KEY_BRANCH_LOCATION = "branch_location";
    public static final String KEY_WAREHOUSE_LOCATION = "warehouse_location";
    public static final String KEY_WAREHOUSE_LATITUDE = "warehouse_latitude";
    public static final String KEY_WAREHOUSE_LONGITUDE = "warehouse_longitude";
    public static final String KEY_WAREHOUSE_NAME = "warehouse_name";
    public static final String KEY_BRANCH_ID = "branch_id";
    public static final String KEY_ADDRESS_1 = "address1";
    public static final String KEY_ADDRESS_2 = "address2";
    public static final String KEY_CITY = "city";
    public static final String KEY_STATE = "state";
    public static final String KEY_POSTAL_CODE = "postal_code";
    public static final String GOOGLE_ADDRESS = "google_address";


    public static final String IN_KG = "In Kg";
    public static final String IN_TON = "In Ton";
    public static final String IN_CUBIC_METER = "In Cubic Meter";
    public static final String IN_LITRES = "In Litres";
    public static final String THREEPL_USER = "3pl_user";

    public static final String TRIP_ACCEPTED = "Trip Accepted";
    public static final String PICKUP_REACHED = "Pickup Reached";
    public static final String VEHICLE_LOADED = "Vehicle Loaded";
    public static final String TRIP_STARTED = "Trip Started";
    public static final String NEARING_DESTINATION = "Nearing Destination";
    public static final String DESTINATION_REACHED = "Destination Reached";
    public static final String COMPLETED = "Completed";
    public static final String NA = "N/A";
    public static final String EMPTY = "";
    public static final int ZOOM = 14;
    public static final int CLUSTER_ZOOM = 20;
    public static final Double LATITUDE = 35.513327;
    public static final Double LONGITUDE = 97.39535869999999;

    public static int TRACE_ROUTE_VALUE = 1;
    public static String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";


    public static int KEY_FTL_CUSTOMER = 500;
    public static int KEY_FTL_VENDOR = 501;
    public static int KEY_LTL_CUSTOMER = 502;
    public static int KEY_LTL_VENDOR = 503;
    public static int KEY_ROUND_TRIP_CUSTOMER = 504;
    public static int KEY_ROUND_TRIP_VENDOR = 505;
    public static int KEY_CUSTOMER = 506;
    public static int KEY_SUB_CUSTOMER = 507;

    public static String KEY_VIEW_MENU = "viewMenu";
    public static String FRESH_DESK_CONTACT_NO = "08041701316";

    public static float KEY_ZOOM_MARKER_ANIM = 14f;
    public static float KEY_ZOOM_HERE_MARKER_ANIM = 7.5f;
//    public static float KEY_ZOOM_HERE_MARKER_ANIM = 3.95f;


    public static final String URL_GOOGLE_API = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&key=%s&latlng=%s,%s";
    public static final String GOOGLE_API_KEY = "AIzaSyBjE1eaTyn8ELbunCIvrvGg22gHI-JktG0";
    //    public static final String URL_BASE = "https://demo2.transo.in/api/";
    public static final String URL_DASHBOARD_COUNT = "carrier/dashboard";
    public static final String URL_ALL_VEHICLES = "carrier/allVehicles";
    public static final String URL_OPERATIONAL_REPORTS = "operationalReports";
    public static final String URL_AVAILABLE_VEHICLES = "carrier/availableVahicle";
    public static final String URL_Vehicle_attribute = "carrier/vehicle_Attribute";
    public static final String URL_ACTIVE_VEHICLES = "carrier/activeVehicles";
    public static final String URL_INACTIVE_VEHICLES = "carrier/inactiveVehicles";
    public static final String URL_MOVING_VEHICLES = "carrier/movingVehicles";
    public static final String URL_IDLE_VEHICLES = "carrier/idleVehicles";
    public static final String URL_GET_VEHICLE_LOCATION = "carrier/getVehicleLocation/";
    public static final String URL_EMPTY_VEHICLES = "carrier/emptyVehicles";
    public static final String URL_AUTO_BOOKING_LIST = "bookingRest/routeList";
    public static final String URL_AUTO_History_BOOKING_LIST = "bookingRest/historyrouteList";
    public static final String URL_RENEWAL_ALERTS = "carrier/renewal_alerts";

    public static final String URL_HERE_API = "https://revgeocode.search.hereapi.com/v1/revgeocode?at=%s,%s&lang=en-US";
    public static final String HERE_API_KEY = "Bearer 8XBbN_k0n2U1OYtB-i20Zh1hbLOjxIprmKAhKiTGESk";

    public static final Double DEFAULT_HERE_LAT = 12.97194;
    public static final Double DEFAULT_HERE_LNG = 77.59369;

    public static final String ONLY_CHAR = "^[a-zA-Z ]+$";
    public static final String ONLY_NUMBER = "^[0-9]+$";
    public static final String ONLY_CHAR_NUMBER = "^[0-9a-zA-Z ]+$";
    public static final String ONLY_CHAR_NUMBER_NO_SPACE = "^[0-9a-zA-Z]+$";
    public static final String ONLY_CHAR_NUMBER_NO_SPACE_DOT = "^[/.0-9a-zA-Z]+$";
    public static final String ONLY_CHAR_NUMBER_NO_SPACE_DOT_email = "^[._@0-9a-zA-Z]+$";

    public static class DecimalDigitsInputFilter implements InputFilter {
        Pattern pattern;

        public DecimalDigitsInputFilter(int digitsBeforeDecimal, int digitsAfterDecimal) {
            pattern = Pattern.compile("(([1-9]{1}[0-9]{0," + (digitsBeforeDecimal - 1) + "})?||[0]{1})((\\.[0-9]{0," + digitsAfterDecimal + "})?)||(\\.)?");
        }

        @Override
        public CharSequence filter(CharSequence source, int sourceStart, int sourceEnd, Spanned destination, int destinationStart, int destinationEnd) {
            // Remove the string out of destination that is to be replaced.
            String newString = destination.toString().substring(0, destinationStart) + destination.toString().substring(destinationEnd);

            // Add the new string in.
            newString = newString.substring(0, destinationStart) + source.toString() + newString.substring(destinationStart);

            // Now check if the new string is valid.
            Matcher matcher = pattern.matcher(newString);

            if (matcher.matches()) {
                // Returning null indicates that the input is valid.
                return null;
            }

            // Returning the empty string indicates the input is invalid.
            return "";
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static BitmapDescriptor getBitmapDescriptor(int id, Context c) throws Exception {
        Drawable vectorDrawable = c.getDrawable(id);
        int h = vectorDrawable.getIntrinsicHeight();
        int w = vectorDrawable.getIntrinsicWidth();
        vectorDrawable.setBounds(0, 0, w, h);
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bm);
    }

    public static void zoomRoute(GoogleMap googleMap, List<LatLng> lstLatLngRoute) {

        if (googleMap == null || lstLatLngRoute == null || lstLatLngRoute.isEmpty()) return;

        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
        for (LatLng latLngPoint : lstLatLngRoute)
            boundsBuilder.include(latLngPoint);

        int routePadding = 100;
        LatLngBounds latLngBounds = boundsBuilder.build();

        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, routePadding));
    }



}
