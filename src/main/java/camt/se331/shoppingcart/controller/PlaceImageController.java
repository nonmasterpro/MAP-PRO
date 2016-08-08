package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.Image;
import camt.se331.shoppingcart.entity.Place;
import camt.se331.shoppingcart.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Dto on 3/29/2016.
 */
@CrossOrigin
@Controller
@RequestMapping("/productImage")
public class PlaceImageController {
    @Autowired
    PlaceService placeService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Place addImage(HttpServletRequest request,
                          HttpServletResponse response, @RequestParam("placeid")Long placeId){
        MultipartHttpServletRequest mRequest;
        Place place = placeService.getPlace(placeId);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getOriginalFilename());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());
                image.setCreated(Calendar.getInstance().getTime());
                placeService.addImage(place,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return place;
    }

    @RequestMapping(value = "/remove",method = RequestMethod.DELETE)
    @ResponseBody
    public Place edit(@RequestParam("placeid") Long placeId, @RequestParam("imageid") Long imageid){
        Place place = placeService.getPlace(placeId);
        //System.out.println("----------- " + productId + " --------" + imageid);
        return placeService.removeImage(place,imageid);
    }
}
