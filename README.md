# EasyMediaPicker
 this library has more options to get media from your phone gallery and camera - photos and vedios

#usage :
{

Request(this@MainActivity).openMedia(Config.Builder().requestType(RequestType.SingleImage).build()) {
                                
                                Log.e("ImagePath22", "openMedia: ${it.data?.data?.path}")
                                
}                                                                                    
                                                
  you have multi TYPES for request 
1- RecordVideo 
2- SingleImage
3- Camera
4- VideoFromGallery

all you have to do you can just change this type RequestType.(TYPE)
