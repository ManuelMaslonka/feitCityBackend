package sk.uniza.feit.site.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.feit.site.mappers.SettingsMapper;
import sk.uniza.feit.site.rest.api.SettingsRestApi;
import sk.uniza.feit.site.rest.dto.SettingsDto;
import sk.uniza.feit.user.domain.SettingsService;

@RestController
public class SettingsController implements SettingsRestApi {

    private final SettingsService settingsService;
    private final SettingsMapper settingsMapper;

    public SettingsController(SettingsService settingsService, SettingsMapper settingsMapper) {
        this.settingsService = settingsService;
        this.settingsMapper = settingsMapper;
    }

    @Override
    public ResponseEntity<SettingsDto> getSettings() {
        return ResponseEntity.ok(settingsMapper.toDto(settingsService.getSettings()));
    }

    @Override
    public ResponseEntity<Void> updateSettings(SettingsDto settingsDto) {
        settingsService.updateSettings(settingsMapper.toEntity(settingsDto));
        return ResponseEntity.noContent().build();
    }
}
