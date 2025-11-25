// Navbar Dropdown Functionality
(function() {
    'use strict';
    
    // Define functions in global scope
    window.toggleUserDropdown = function(event) {
        if (event) {
            event.preventDefault();
            event.stopPropagation();
        }
        const menu = document.getElementById('userDropdownMenu');
        const arrow = document.getElementById('dropdownArrow');
        
        if (menu) {
            const isOpen = menu.classList.contains('show');
            if (isOpen) {
                menu.classList.remove('show');
                if (arrow) arrow.style.transform = 'rotate(0deg)';
            } else {
                menu.classList.add('show');
                if (arrow) arrow.style.transform = 'rotate(180deg)';
            }
        }
    };
    
    window.closeUserDropdown = function() {
        const menu = document.getElementById('userDropdownMenu');
        const arrow = document.getElementById('dropdownArrow');
        if (menu) {
            menu.classList.remove('show');
            if (arrow) arrow.style.transform = 'rotate(0deg)';
        }
    };
    
    // Initialize dropdown when DOM is ready
    function initDropdown() {
        const dropdown = document.getElementById('userDropdown');
        const menu = document.getElementById('userDropdownMenu');
        const accountLink = document.getElementById('accountLink');
        const logoutLink = document.getElementById('logoutLink');
        
        if (dropdown && menu) {
            // Add click listener to dropdown
            dropdown.addEventListener('click', function(event) {
                event.stopPropagation();
                toggleUserDropdown(event);
            });
            
            // Close when clicking menu items
            if (accountLink) {
                accountLink.addEventListener('click', closeUserDropdown);
            }
            if (logoutLink) {
                logoutLink.addEventListener('click', closeUserDropdown);
            }
            
            // Close when clicking outside (only add once)
            if (!window.dropdownOutsideClickAdded) {
                document.addEventListener('click', function(event) {
                    const userSection = document.querySelector('.user-section');
                    if (userSection && menu && !userSection.contains(event.target)) {
                        closeUserDropdown();
                    }
                });
                window.dropdownOutsideClickAdded = true;
            }
            
            // Close on escape key (only add once)
            if (!window.dropdownEscapeKeyAdded) {
                document.addEventListener('keydown', function(event) {
                    if (event.key === 'Escape') {
                        closeUserDropdown();
                    }
                });
                window.dropdownEscapeKeyAdded = true;
            }
        }
    }
    
    // Initialize when DOM is ready
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', initDropdown);
    } else {
        initDropdown();
    }
    
    // Fallback initialization
    setTimeout(initDropdown, 100);
    setTimeout(initDropdown, 500);
})();

