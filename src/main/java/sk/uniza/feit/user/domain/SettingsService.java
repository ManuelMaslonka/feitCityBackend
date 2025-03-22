package sk.uniza.feit.user.domain;

import org.springframework.stereotype.Service;

@Service
public class SettingsService {

    private final SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public Settings getSettings() {
        return settingsRepository.findAll().get(0);
    }

    public boolean getEnabledLogin() {
        return settingsRepository.findAll().get(0).isEnabledLogin();
    }

    public boolean getEnabledRegistration() {
        return settingsRepository.findAll().get(0).isEnabledRegistration();
    }

    public void updateSettings(Settings settings) {
        Settings oldSettings = settingsRepository.findAll().get(0);
        oldSettings.setEnabledLogin(settings.isEnabledLogin());
        oldSettings.setEnabledRegistration(settings.isEnabledRegistration());
        settingsRepository.save(oldSettings);
    }

}
