# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Initial unified SDK covering all 8 Essabu service modules
- HR module: employees, contracts, leaves, payroll, shifts, departments, positions, attendance, documents, training, skills, recruitment, performance, onboarding, timesheets, benefits, disciplinary, loans, expense reports, config
- Accounting module: accounts, invoices, payments, wallets, journals, quotes, credit notes, tax rates, fiscal years, currencies, inventory, coupons, reports, config, insurance, billing, recurring invoices
- Identity module: auth (login, register, 2FA, password reset), users, roles, permissions, tenants, companies, branches, profiles, sessions, API keys
- Trade module: customers, contacts, opportunities, products, sales orders, purchase orders, suppliers, contracts, campaigns, activities, warehouses, stock, delivery notes, goods receipts, reports
- Payment module: payment intents, transactions, refunds, payouts, subscriptions, loans, KYC, payment accounts, reports
- E-Invoice module: electronic invoicing, public verification
- Project module: projects, tasks, milestones, resource allocations, reports
- Asset module: assets, vehicles, maintenance (logs & schedules), fleet (fuel & trip logs)
- Common infrastructure: HttpClientWrapper, AuthInterceptor, RetryHandler, JsonMapper
- Exception hierarchy: EssabuApiException, NotFoundException, ValidationException, UnauthorizedException, ForbiddenException, RateLimitException, ServerException
- Pagination support: PageRequest, PageResponse
- Spring Boot auto-configuration with EssabuProperties
