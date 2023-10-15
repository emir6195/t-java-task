package com.emir.tebtask.labeling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/labeling")
public class LabelingController {

    private final LabelingService labelingService;
    @Autowired
    public LabelingController(LabelingService labelingService) {
        this.labelingService = labelingService;
    }
    @PostMapping()
    public LabelingResponse fetchLabel(@RequestBody Labeling text) {
        return labelingService.tagData(text);
    }
}
